public class Olympics {

    public static void main(String[] args) {
        Team team = new Team("Олимпийские резервы");
        team.doIt(new Course());
        team.showResults();
    }
}
