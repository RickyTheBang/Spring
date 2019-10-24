package h01_09_02_AOPmetSpring.model;

public class MyExtraInterfaceImpl implements MyExtraInterface {
    @Override
    public String sayGoodnight(String name) {
        return "Goodnight " + name;
    }
}
