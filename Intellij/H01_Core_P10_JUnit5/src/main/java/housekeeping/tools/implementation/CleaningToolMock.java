package housekeeping.tools.implementation;

import housekeeping.tools.CleaningTool;

public class CleaningToolMock implements CleaningTool {
    private boolean cleanCalled = false;
    @Override
    public void doCleanJob() {
        cleanCalled=true;
    }

    public boolean isCalled(){
        return cleanCalled;
    }
}
