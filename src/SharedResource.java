public class SharedResource {

      
    private int id;
    private int data;

    public SharedResource(){
        this.id = 0;
        this.data = 0;
    }

    public SharedResource(int id, int data) {
        this.id = id;
        this.data = data;
    }

    public int getId( ) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getData( ) {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString( ) {
        return "SharedResource{" +
                "id=" + id +
                ", data=" + data +
                '}';
    }
}
