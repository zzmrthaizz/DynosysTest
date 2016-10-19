package com.thai.dynosystest.model;

/**
 * Created by user on 17/10/2016.
 */
public class Hero {
    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroType() {
        return heroType;
    }

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    public Hero(String heroName, String heroType,int heroImage,int heroTypeImage,String heroStory) {
        this.heroName = heroName;
        this.heroType = heroType;
        this.heroImage = heroImage;
        this.heroTypeImage = heroTypeImage;
        this.heroStory = heroStory;
    }

    String heroName;
    String heroType;

    public int getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(int heroImage) {
        this.heroImage = heroImage;
    }

    int heroImage;

    public int getHeroTypeImage() {
        return heroTypeImage;
    }

    public void setHeroTypeImage(int heroTypeImage) {
        this.heroTypeImage = heroTypeImage;
    }

    int heroTypeImage;

    public String getHeroStory() {
        return heroStory;
    }

    public void setHeroStory(String heroStory) {
        this.heroStory = heroStory;
    }

    String heroStory;
}
