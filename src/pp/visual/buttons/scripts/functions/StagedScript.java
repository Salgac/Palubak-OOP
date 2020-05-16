package pp.visual.buttons.scripts.functions;

/**
 * Interface for scripts that need staging
 *
 * @author Dominik Šalgovič
 */
public interface StagedScript {

    /**
     * First stage
     */
    private void firstStage() {
    }

    /**
     * Second stage
     */
    private void secondStage() {
    }

    /**
     * Third stage
     */
    private void thirdStage() {
    }

    /**
     * Fourth stage
     */
    private void fourthStage() {
    }

    /**
     * fifth stage
     */
    private void fifthStage() {
    }

    /**
     * final stage
     */
    private void endStage() {
    }

    /**
     * enum holding information about current stage
     */
    enum STAGE {
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        FIFTH
    }
}
