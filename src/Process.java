public class Process {
    private int pid;
    private int priority;
    private int arrivalTime;
    private int blockedTime;
    private int burstTime;
    //Task 0 Add Record 1 Delete Record 2 Read Record 3 Calculate Record
    private int task;
    private int state;
    private final int  READY = 0 ; // States can either be 0 1 2 or 3 each int directly correlates to the possibleState array
    public final int  RUNNING = 1 ;
    private final int  BLOCKED = 2 ;
    private final int  TERMINATED = 3 ;
    private final int  WAITING = 4 ;

    public Process(int i){
        //generate random values for the process
        this.pid = i;
        this.task = (int) (Math.random() * 4);
        this.priority = (int) (Math.random() * 4);
        this.arrivalTime = (int) (Math.random() * 30);
        this.blockedTime = 0;
        this.burstTime = (int) ((Math.random() * 100)+1);
        state = WAITING;
    }

    public Process(int pid, int task, int priority, int arrivalTime, int blockedTime, int burstTime) {
        this.pid = pid;
        this.task = task;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.blockedTime = blockedTime;
        this.burstTime = burstTime;
        state = WAITING;
    }

    public int getPid( ) {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getTask( ) {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public int getPriority( ) {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getArrivalTime( ) {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBlockedTime( ) {
        return blockedTime;
    }

    public void setBlockedTime(int blockedTime) {
        this.blockedTime = blockedTime;
    }

    public void incrementBlockedTime(){
        this.blockedTime++;
    }

    public int getBurstTime( ) {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getState( ) {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    //set state to ready
    public void setReady(){
        this.state = READY;
    }
    //set state to running
    public void setRunning(){
        this.state = RUNNING;
    }
    //set state to blocked
    public void setBlocked(){
        this.state = BLOCKED;
    }
    //set state to terminated
    public void setTerminated(){
        this.state = TERMINATED;
    }



    @Override
    public String toString( ) {
        return "Process{" +
                "pid=" + pid +
                ", task=" + task +
                ", priority=" + priority +
                ", arrivalTime=" + arrivalTime +
                ", blockedTime=" + blockedTime +
                ", burstTime=" + burstTime +
                '}';
    }
}
