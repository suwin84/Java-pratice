public class Obj1 {
        public static void main(String[] args) {

        Students s0 = new Students();
        Students s1 = new Students("peter");
        Students s2 = new Students("tom", 20);

        s2.study();
        s1.study("youtube");
        // s1.study("vscode");
        // s1.study("vscode","hello", "you");
        s1.study(new String[] {"vscode","hello", "you", "oxox"});

        // // 型別 + 數量
        // s2.study("a", 1);
        // s2.study( 1, "a");


    }
}

class Students {
    String name;

    int age;

    Students() {
        age = 18;
    }

    Students(String name) {
        this.name = name;
    }

    Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void study() {
        System.out.println(name + " read a book.");
    }

    void study(String bookName) {
        System.out.println(name + " read the book of " + bookName);
    }

    void study(int time) {

        
    }

    void study(int time, String name) {
        System.out.println("case 1");
    }

    void study(String time, int name) {
        System.out.println("case 2");
    }

    // void study(String ... books){
    //     for(int i = 0;i<books.length;i++){
    //         System.out.println(books[i]);
    //     }
    // }

    void study(String[] books){
        for(int i = 0;i<books.length;i++){
            System.out.println(books[i]);
        }
    }

}