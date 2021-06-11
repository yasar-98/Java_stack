public class SinglyLinkedList {
    public Node head;
	public SinglyLinkedList() {
		this.head = null;
    }

    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }
	public Boolean remove(){
		Node runner=head;
		if (head == null){
			return false;
		}
		else{ 
			if (head.next == null){
				head=null;
				return true;	
			}
			else{
				Node runner2=head.next;
				while(runner2.next != null){
					runner = runner.next;
					runner2=runner.next;
				}
				runner.next = null;
				return true;	
			}
			
		}
	}
	public void printValues(){
		Node runner=head;
		if (head == null){
			System.out.println("empty linked list");
		}
		else{ 
			System.out.println(head.value);
			while(runner.next != null){
				runner = runner.next;
				System.out.println(runner.value);
			}
		}
	}
}