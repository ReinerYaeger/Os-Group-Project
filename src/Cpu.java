import java.util.PriorityQueue;

public class Cpu {
    private Process process;
    private SharedResource sharedResource;

    public Cpu(){
        this.process = null;
        this.sharedResource = null;
    }

    public Cpu(Process process, SharedResource sharedResource) {
        this.process = process;
        this.sharedResource = sharedResource;
    }

    public void loadProcess(){
        PriorityQueue<Process> pq = new PriorityQueue<Process>(20, new ProComparator());

        //loop that counts to 20
        for(int i = 0; i < 20; i++) {
            pq.add(new Process());
        }

        for(Process p : pq) {
            process(pq);
        }
    }

    public void process(PriorityQueue<Process> pq){

        process = pq.poll();
        if(process.getState() == 0){
            process.setState(1);
            System.out.println(process.getState());
            process.setBurstTime(process.getBurstTime() - 1);
            if(process.getBurstTime() == 0){
                process.setState(3);
            }
        }
    }





    public Process getProcess( ) {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public SharedResource getSharedResource( ) {
        return sharedResource;
    }

    public void setSharedResource(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public String toString( ) {
        return "Cpu{" +
                "process=" + process +
                ", sharedResource=" + sharedResource +
                '}';
    }
}
