package Java_Basic_And_OOP.M_Basic_OOP_Project.Tic_Tac_Toe_Again;

public class Board {
    private String board[] = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
    int count = 0;
    public void displayBoard(){
        System.out.println(" " + board[0] + " | " + board[1] +  " | " + board[2]);
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] +  " | " + board[5]);
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] +  " | " + board[8]);
        System.out.println("-----------");
    }

    boolean checkDraw(){
        //Phương thức này sẽ đếm số ô trên bàn cờ, vì bàn cờ có 9 ô nên giá trị tối đa của count sẽ bằng 9, nếu count = 9 --> không còn ô nào trống trên bàn cờ
        if(count == 9) return true;
        return false;
    }

    boolean updatePosition(int position, String type){
        //Phương thức cập nhật bảng
        //Nếu người dùng nhập vị trí n, thì tại vị trí n - 1 sẽ được cập nhật quân cờ

        //Nếu người dùng chưa nhập quân cờ, cập nhật bàn cờ, nếu tại vị trí đó đã chứa quân cờ, yêu cầu người dùng nhập quân cờ tại vị trí khác

        if(board[position - 1] == " "){
            board[position - 1] = type;
            return true;
        }
        else{
            System.out.println("SELECT ANOTHER POSITION!");
            return false;
        }
    }

    boolean checkWinner(String type){
        //Phương thức này sẽ kiểm tra người thắng cuộc
        //Người chơi cờ caro thắng khi các ô nằm trên cùng 1 hàng, 1 cột hoặc 1 đường chéo đều lấp đầy bởi quân cờ của người đó

        if((board[0] == type && board[1] == type && board[2] == type)
        || (board[3] == type && board[4] == type && board[5] == type)
        || (board[6] == type && board[7] == type && board[8] == type)
        || (board[0] == type && board[3] == type && board[6] == type)
        || (board[1] == type && board[4] == type && board[7] == type)
        || (board[2] == type && board[5] == type && board[8] == type)
        || (board[0] == type && board[4] == type && board[8] == type)
        || (board[2] == type && board[4] == type && board[6] == type)){
            return true;
        }
        return false;
    }
}
