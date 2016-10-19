package com.thai.dynosystest.model;

/**
 * Created by user on 17/10/2016.
 */
public class Skill {

    public Skill() {

    }

    public Skill(int imageSkill, String skillDame, String skillEffect) {
        this.imageSkill = imageSkill;
        this.skillEffect = skillEffect;
        this.skillName = skillDame;
    }

    public int getImageSkill() {
        return imageSkill;
    }

    public void setImageSkill(int imageSkill) {
        this.imageSkill = imageSkill;
    }

    public String getSkillEffect() {
        return skillEffect;
    }

    public void setSkillEffect(String skillEffect) {
        this.skillEffect = skillEffect;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    int imageSkill;
    String skillEffect;
    String skillName;
}
