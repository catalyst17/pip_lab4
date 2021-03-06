package beans;

import dao.GenericDao;
import entities.UserEntity;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Stateless;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Lock(LockType.WRITE)
@Path(value = "/auth/")
@Produces(MediaType.APPLICATION_JSON)
public class AuthBean {
    /*@EJB*/
    private GenericDao<UserEntity, String> userService = new GenericDao<UserEntity, String>(UserEntity.class);

    @Path("login")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response loginUser(@FormParam("login") String login, @FormParam("password") String password, @Context HttpServletResponse resp, @Context HttpServletRequest req) {
        UserEntity usr = userService.findById(login);
        if (usr == null) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("User doesn't exist.").build();
        }
        if (usr.getPassword() != password.hashCode()) {
            return Response.status(Response.Status.FORBIDDEN).entity("Incorrect password.").build();
        }
        //req.getSession().setAttribute("login", login);
        Cookie cookie = new Cookie("login", login);
        cookie.setPath("/Lab4-war5");
        resp.addCookie(cookie);
        return Response.status(Response.Status.OK).entity("Logged in.").build();
    }

    @Path("logout")
    @GET
    public Response logoutUser(@Context HttpServletResponse resp, @Context HttpServletRequest req) {
        //req.getSession().invalidate();
        Cookie cookie = new Cookie("login", "");
        cookie.setMaxAge(0);
        cookie.setPath("/Lab4-war5");
        resp.addCookie(cookie);
        return Response.status(Response.Status.OK).entity("Logged out.").build();
    }

    private boolean checkUser(String login, String password) {
        if (login == null || login.equals("") || login.length() > 15) {
            return false;
        }
        return !(password == null || password.equals("") || password.length() > 15);
    }
}
