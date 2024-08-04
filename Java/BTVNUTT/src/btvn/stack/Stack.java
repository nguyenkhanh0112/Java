package btvn.stack;

public class Stack {
        private Node top;
        private int size;

        public Stack(){
            this.top=null;
            this.size=0;
        }
        public Node getTop(){
            return top;
        }
        public void setTop(Node top){

            this.top= top;
        }
        /*  push(): đẩy một phần tử dữ liệu vào đỉnh ngăn xếp,tham số là một giá trị kiểu int
        (giá trị của phần tử cần tiếp nhận).Phương thức không trả lại giá trị gì. */
        public void push(int number){
            Node node = Node.createNode(number);
            if(getTop()==null){
                setTop(node);
                this.size=1;
            }else{
                node.setNext(top);
                top=node;
                this.size++;
            }
        }
        /*pop( ): nếu ngăn xếp không rỗng, lấy phần tử trên đỉnh ngăn xếp ra khỏi ngăn xếp,
        trả về giá trị của phần tử đó; nếu ngăn xếp rỗng, trả về giá trị -1. */
        public int pop(){
            if(!isEmpty()){
                Node node = top;
                top=node.getNext();
                this.size--;
                return node.getItem();
            }
            return -1;
        }
        //isEmpty( ): trả về giá trị true nếu ngăn xếp rỗng, ngược lại trả về false.
        public boolean isEmpty(){
            if(getTop()==null)
                return true;
            return false;
        }
        //numOfElement( ): trả về số phần tử hiện có trong ngăn xếp.
        public int numOfElement(){
            return this.size;
        }
        /*
        search( ): tìm kiếm một số nguyên trong ngăn xếp. Nếu tìm thấy, hàm trả lại số
        thứ tự của node trong ngăn xếp chứa giá trị nguyên này. Nếu không tìm thấy, hàm
        trả về 0
        */
        public int search(int x){
            if(isEmpty())
                return 0;
            Node temp = top;
            int index=this.size;
            while (temp!=null){
                if(temp.getItem()==x){

                    return  index;
                }

                index--;
                temp=temp.getNext();
            }
            return 0;
        }
        //display( ): in ra danh sách các phần tử hiện có trong ngăn xếp
        public void display(){
           Node temp = top;
           if(isEmpty())
               return;
           while (temp!=null){
               System.out.print(temp.getItem()+" ");
               temp=temp.getNext();
           }
        }
}
