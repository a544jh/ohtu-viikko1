package ohtu;

public class Submission {

    private String student_number, week, hours;
    private String a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    private int tasks_done() {
        String[] tasks = {a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21};
        int d = 0;
        for (String b : tasks) {
            if (b != null && b.equals("true")) {
                d++;
            }
        }
        return d;
    }

    private int tasks_total() {
        String[] tasks = {a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21};
        int d = 0;
        for (String b : tasks) {
            if (b != null) {
                d++;
            }
        }
        return d;
    }

    @Override
    public String toString() {
        return student_number + " week " + week + " " + tasks_done() + "/" + tasks_total() + " tasks done in " + hours + " hours";
    }

}
