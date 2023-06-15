package org.informatics.publication;

public class PaperLoadedException extends RuntimeException {
    private int maxPaperSheets;
    private Publication publication;

    public PaperLoadedException(int maxPaperSheets, Publication publication) {
        this.maxPaperSheets = maxPaperSheets;
        this.publication = publication;
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        String publicationTitle = publication.getTitle();
        return "The machine for publication with title " +  publicationTitle +  " can only be loaded with: " + maxPaperSheets + " sheets";
    }
}
