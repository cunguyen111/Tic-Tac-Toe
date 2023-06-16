package Java_Basic_And_OOP.M_Basic_OOP_Project.Tic_Tac_Toe_Again;

import java.util.Scanner;

public class Game {
    
    //Trước tiên, phải khởi tạo tất cả các đối tượng của các lớp còn lại, vì chúng ta sử dụng các đối tượng này trong logic trò chơi là rất nhiều

    Player player1 = new Player("X"); //Người chơi quân X
    Player player2 = new Player("O"); //Người chơi quân Y
    Board board = new Board(); //Khởi tạo bàn cờ để tham chiếu đến các logic thắng thua dựa trên bàn cờ
    Player currentPlayer = player1; //Khởi tạo đối tượng ` Người chơi hiện tại `. Mục đích của việc tạo ra biến này để: mỗi người sẽ được đặt quân cờ theo lượt(người chơi X luôn luôn được đặt quân đầu tiên), sau khi người chơi X đặt quân xong sẽ đến người chơi O

    //Chúng ta bắt đầu khởi tạo phương thức chính của game
    void play(){
        //TODO: Trò chơi sẽ bắt đầu trong 1 vòng lặp vô tận

        String message; //Biến này được dùng để thông báo nhập quân
        
        while(true){
            message = "ENTER THE POSITION(1 - 9):";
            System.out.println(currentPlayer.name + " " + message);
            //Nhập thông báo theo đúng định dạng
            Scanner sc = new Scanner(System.in);
            int position = sc.nextInt();

            //Phương thức updateBoard sẽ trả về true khi người chơi chọn vị trí trống

            //TODO: Đây là các điều kiện để ngắt vòng lặp(kết thúc trò chơi)
            if(board.updatePosition(position, currentPlayer.type)){
                board.displayBoard();

                //Cứ mỗi lần cập nhật bàn cờ, sẽ đều kiểm tra người thắng cuộc
                
                //Nếu đáp ứng 1 trong những điều kiện của phương thức checkWinner, in ra người chơi hiện tại `currentPlayer` thắng trò chơi
                if(board.checkWinner(currentPlayer.type)){
                    System.out.println(currentPlayer.name + " WON!");
                    break;
                }
                //Nếu hòa cờ sẽ in ra thông báo hòa cờ, hòa khi và chỉ khi các ô đều được lấp đầy nhưng không có 3 quân cờ giống nhau nào liên tiếp trong 1 cột, 1 hàng hoặc 1 đường chéo
                else if(board.checkDraw()){
                    System.out.println("DRAW!");
                    break;
                }

                else{
                    //*Là một trường hợp ngoại lệ, điều kiện này sẽ không kết thúc vòng lặp, điều kiện này tạo ra để bắt buộc mỗi người chơi đều được đi đúng theo lượt(X trước O sau và tiếp tục như thế)
                    if(currentPlayer == player1){
                        //Nếu bàn cờ đã được cập nhật, người chơi hiện tại sẽ thay đổi qua người chơi 2, ngược lại nếu bàn cờ chưa được cập nhật --> giữ nguyên trạng thái ban đầu
                        currentPlayer = player2;
                    }
                    else{
                        currentPlayer = player1;
                    }
                }
            }
        }
    }
}
