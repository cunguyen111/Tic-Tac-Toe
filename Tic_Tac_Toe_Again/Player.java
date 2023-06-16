package Java_Basic_And_OOP.M_Basic_OOP_Project.Tic_Tac_Toe_Again;
import java.util.Scanner;

public class Player {
    //Nhập tên cho mỗi người chơi tương ứng để phân biệt rõ hơn(người chơi quân X hoặc quân O)

    String name;

    String type;

    //Khởi tạo một constructor để nhập thông tin từ người chơi
    Player(String type){
        this.type = type; //Mục đích để trỏ đến đối tượng hiện tại, túc người chơi X sẽ nhập tên của người chơi X, người chơi O sẽ nhập tên của người chơi O

        Scanner sc = new Scanner(System.in);

        if(type == "X"){
            System.out.print("PLAYER X, ENTER YOUR NAME: ");
            name = sc.nextLine();
        }
        else{
            System.out.print("PLAYER O, ENTER YOUR NAME: ");
            name = sc.nextLine();
        }
    }
}
