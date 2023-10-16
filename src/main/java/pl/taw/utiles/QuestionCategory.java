package pl.taw.utiles;

public enum QuestionCategory {

    JAVA("Java"),
    PYTHON("Python"),
    OTHER("Other");

    private final String displayName;

    QuestionCategory(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

}
