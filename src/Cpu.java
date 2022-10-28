import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Cpu {
    private Process process;
    private ArrayList<SharedResource> srl;
    private int rbs; //Resource being used

    public Cpu(){
        rbs =0;

    }

    public Cpu(Process process, ArrayList srl) {
        this.process = process;
        this.srl = srl;
    }

    public void stageProcess(Process process){
        process.setReady();
        this.process = process;
    }

    public int executeProcess(ArrayList<SharedResource> srl,int index, int task){

        int srlIndex = index;
        process.setRunning();

        System.out.println("Process Id: "+ process.getPid());
        System.out.println("Process State: " + process.getState());
        if(task == 0) {

            int random = (int) (Math.random() * 100);
            System.out.println("Adding Data for Index " + srlIndex);
            srl.get(srlIndex).setData(random);
            System.out.println("Data Added: = "+ random);
            System.out.println("Shared Resource "+  srl.get(srlIndex).toString());
            System.out.println();
        }else if (task == 1) {
            System.out.println("Deleting Data for Index " + srlIndex);
            System.out.println("Shared Resource Previous value "+  srl.get(srlIndex).getData());
            if(srl.get(srlIndex).getData() != 0)
                srl.get(srlIndex).setData(0);
            System.out.println("Data Deleted: = " + srl.get(srlIndex).getData());
            System.out.println("Shared Resource "+  srl.get(srlIndex).toString());
            System.out.println();
        }else if(task == 2) {
            System.out.println("Reading Data for Index " + srlIndex);
            System.out.println("Data: "+srl.get(srlIndex).getData());
            System.out.println("Shared Resource "+  srl.get(srlIndex).toString());
            System.out.println();
        }else {
            System.out.println("Calculating Data");
            int total = 0;

            for(SharedResource srTmp : srl){
                total = srTmp.getData()+total;
            }
            System.out.println("Total: "+total);
            System.out.println("Shared Resource "+  srl.get(srlIndex).toString());
            System.out.println();
        }

        process.setTerminated();
        System.out.println("Process Id: "+ process.getPid());
        System.out.println("Process State: " + process.getState());
        return srlIndex+1;
    }

    public Process getProcess( ) {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public List getSrl( ) {
        return srl;
    }

    public void setSrl(ArrayList<SharedResource> srl) {
        this.srl = srl;
    }

    public int getRbs( ) {
        return rbs;
    }

    public void setRbs(int rbs) {
        this.rbs = rbs;
    }

    @Override
    public String toString( ) {
        return "Cpu{" +
                "process=" + process +
                ", sharedResource=" + srl +
                '}';
    }
}
