import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by DrScott on 10/12/15.
 */
public class ToDo {
    static void printToDos(ArrayList<ToDoItem> todos){
        int todoNum = 1;
        for (ToDoItem todo : todos) {//for loop
            String checkbox = "[ ]";
            if (todo.isDone){
                checkbox = "[x]";
            }
            System.out.println(todoNum + ". "+ checkbox + " " + todo.text);
            todoNum++;              //increases todoNUm by 1
        }
    }
    public static void main(String[] args){
        ArrayList<ToDoItem> todos = new ArrayList();//creating array list
        Scanner scanner = new Scanner(System.in); //creates a scanner we can use repeatedly

        while(true) {                   //making an infinite loop
            printToDos(todos);
            System.out.println("Options");
            System.out.println("[1] Create todo");
            System.out.println("[2] Mark todo as done or not done ");

            String option = scanner.nextLine();
            int optionNum = Integer.valueOf(option);

            if (optionNum == 1)
            {
                System.out.println("Type a todo and hit enter ");
                String todo = scanner.nextLine();
                ToDoItem item = new ToDoItem(todo);

                todos.add(item);
            } else if (optionNum == 2)
            {
                System.out.printf("Type the number of the todo you want to toggle ");
                String select = scanner.nextLine();
                try {        //try catch is like an if statement but just for Exceptions
                    int selectNum = Integer.valueOf(select);
                    ToDoItem item = todos.get(selectNum - 1);//subtract one to read the proper spot in the array
                    item.isDone = !item.isDone; //is a toggle almost
                } catch (Exception e) {
                    System.out.println("An error occured, smartass.");
                }

            }
            else {
                System.out.println("Invalid number!");
            }
        }
    }
}
