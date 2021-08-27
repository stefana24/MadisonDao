package models;

public class Review {
    private String thoughts;
    private String summary;
    private String nickname;

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Review{" +
                "thoughts='" + thoughts + '\'' +
                ", review='" + summary + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
