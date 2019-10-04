package theDemo.eventHandling;

public class InterestedClass implements StateChangeEventListener {

    private EventCreator creator = new EventCreator ();;


    public void setCreator(EventCreator creator) {
        this.creator = creator;
    }
    public EventCreator getCreator() {
        return creator ;
    }



    public InterestedClass(){
        this.creator.registerEventListener (this);
    }

    @Override
    public void handleEvent(Event event) {
        System.out.println ("What is going on with T?" );
    }

     /*   public InterestedClass(EventCreator creator){
        this.creator = creator;
       // this.creator.register (this);
    }*/
}
