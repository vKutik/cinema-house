package cinema;

import cinema.dao.CinemaHallDao;
import cinema.dao.MovieDao;
import cinema.dao.MovieSessionDao;
import cinema.dao.OrderDao;
import cinema.dao.ShoppingCartDao;
import cinema.dao.TicketDao;
import cinema.dao.UserDao;
import cinema.lib.Injector;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.User;
import cinema.security.AuthenticationService;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.MovieSessionService;
import cinema.service.OrderService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.time.LocalDateTime;

public class Main {
    public static final Injector injector = Injector.getInstance("cinema");
    public static final CinemaHallDao cinemaHallDao = (CinemaHallDao) injector
            .getInstance(CinemaHallDao.class);
    public static final CinemaHallService cinemaHallService = (CinemaHallService) injector
            .getInstance(CinemaHallService.class);
    public static final MovieDao movieDao = (MovieDao) injector.getInstance(MovieDao.class);
    public static final MovieService movieService = (MovieService) injector
            .getInstance(MovieService.class);
    public static final MovieSessionDao movieSessionDao = (MovieSessionDao) injector
            .getInstance(MovieSessionDao.class);
    public static final MovieSessionService movieSessionService = (MovieSessionService) injector
            .getInstance(MovieSessionService.class);
    public static final ShoppingCartDao shoppingCartDao = (ShoppingCartDao) injector
            .getInstance(ShoppingCartDao.class);
    public static final ShoppingCartService shoppingCartService = (ShoppingCartService) injector
            .getInstance(ShoppingCartService.class);
    public static final UserDao userDao = (UserDao) injector.getInstance(UserDao.class);
    public static final UserService userService = (UserService) injector
            .getInstance(UserService.class);
    public static final TicketDao ticketDao = (TicketDao) injector.getInstance(TicketDao.class);
    public static final OrderDao orderDao = (OrderDao) injector.getInstance(OrderDao.class);
    public static final OrderService orderService = (OrderService) injector
            .getInstance(OrderService.class);
    public static final AuthenticationService authenticationService =
            (AuthenticationService) injector
                    .getInstance(AuthenticationService.class);

    public static void main(String[] args) {
        cinemaHallService.add(new CinemaHall(100, "Big hall"));
        movieService.add(new Movie("1 + 1", "family film"));
        movieSessionService
                .add(new MovieSession(movieService.get(1L), cinemaHallService.get(1L), LocalDateTime
                        .of(2021, 10, 11, 10, 1)));

        User user = authenticationService.register("vova", "123");
        shoppingCartService.addSession(movieSessionService.get(1L), user);
        orderService.completeOrder(shoppingCartService.getByUser(user));
        System.out.println(shoppingCartService.getByUser(user).getTickets());
    }
}
