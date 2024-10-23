import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class BankAccount {
    private String h;
    private double b; 
    private double m; 
    private ArrayList<String> t; 
    private int w; 
    private static final int MAX_WITHDRAWALS = 3;

    public BankAccount(String h, double b, double m) {
        this.h = h;
        this.b = b;
        this.m = m;
        this.t = new ArrayList<>();
        this.w = 0;
    }

    public void d(double a) { 
        if (a > 0) {
            b += a;
            logTransaction("Deposit", a);
            System.out.println("Đã gửi " + formatCurrency(a));
        } else {
            System.out.println("Lỗi: Số tiền gửi phải lớn hơn 0.");
        }
    }

   
    public void w(double a) { 
        if (w >= MAX_WITHDRAWALS) {
            System.out.println("Rút " + formatCurrency(a) + " - Lỗi: Bạn đã đạt giới hạn rút tiền tháng này.");
        } else if (a > 0 && a <= b) {
            b -= a;
            w++;
            logTransaction("Withdraw", a);
            System.out.println("Đã rút " + formatCurrency(a));
        } else {
            System.out.println("Lỗi: Số tiền rút không hợp lệ hoặc vượt quá số dư.");
        }
    }

  
    public void a() { 
        double i = b * m / 100; 
        b += i;
        System.out.println("Số dư sau khi cộng lãi: " + formatCurrency(b));
    }

    
    private void logTransaction(String type, double amount) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        String transaction = type + " - " + formatCurrency(amount) + " - " + date;
        t.add(transaction);
    }

    public void p() {
        System.out.println("Lịch sử giao dịch:");
        int index = 1;
        for (String transaction : t) {
            System.out.println(index + ". " + transaction);
            index++;
        }
    }

    
    public void b() { 
        System.out.println("Số dư hiện tại: " + formatCurrency(b));
    }

    private String formatCurrency(double amount) {
        return String.format("%,.0f VNĐ", amount);
    }
}

public class EX5_7_Sol {
    public static void main(String[] args) {
       
        BankAccount a = new BankAccount("Nguyễn Văn A", 5000000, 0.5); // a for account

        System.out.println("Tạo tài khoản mới: Nguyễn Văn A");
        System.out.println("Số dư ban đầu: " + a.formatCurrency(5000000));

        
        a.w(500000); 
        a.w(500000); 

        
        a.b();

        
        a.p();

  
        a.a();
    }
}
