import java.util.List;

public class ShowAndTicket {
    class Show {
        private String movie;
        private String time;
    }

    class Ticket {
        private int seat;
        private int code;
        private List<Show> tickets;
    }
}
