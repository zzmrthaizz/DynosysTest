package com.thai.dynosystest.features.skill;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thai.dynosystest.R;
import com.thai.dynosystest.model.Skill;

import java.util.ArrayList;

/**
 * Created by user on 17/10/2016.
 */
public class SkillsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int resource;
    ArrayList<Skill> skills;
    int resourceHeader;
    Context context;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public SkillsAdapter(Context context, ArrayList<Skill> skills, int item_skill, int item_skill_header) {
        this.skills = skills;
        this.resource = item_skill;
        this.resourceHeader = item_skill_header;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (viewType == TYPE_HEADER) {
            View v = mInflater.inflate(resourceHeader, parent, false);
            return new SkillHeader(v);
        } else {
            View v = mInflater.inflate(resource, parent, false);
            return new SkillHolder(v);
        }
    }

    @Override
    public int getItemCount() {
        if (skills != null)
            return skills.size();
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_HEADER;
        else return TYPE_ITEM;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Skill skill = skills.get(position);
        if (holder instanceof SkillHolder) {
            ((SkillHolder) holder).ivSkill.setImageResource(skill.getImageSkill());
            ((SkillHolder) holder).skillEffect.setText(skill.getSkillEffect());
            ((SkillHolder) holder).skillName.setText(skill.getSkillName());
        } else if (holder instanceof SkillHeader) {

        }
    }

    public void updateData(ArrayList<Skill> skills) {
        if (this.skills != null) {
            this.skills.clear();
            this.skills.addAll(skills);
        } else {
            this.skills = new ArrayList<>();
            this.skills.addAll(skills);
        }
        notifyDataSetChanged();
    }

    private class SkillHolder extends RecyclerView.ViewHolder {
        ImageView ivSkill;
        TextView skillEffect;
        TextView skillName;

        public SkillHolder(View itemView) {
            super(itemView);
            ivSkill = (ImageView) itemView.findViewById(R.id.iv_skill);
            skillEffect = (TextView) itemView.findViewById(R.id.tv_skill_effect);
            skillName = (TextView) itemView.findViewById(R.id.tv_skill_name);
        }
    }

    private class SkillHeader extends RecyclerView.ViewHolder {
        TextView heroName;

        public SkillHeader(View headerView) {
            super(headerView);
            heroName = (TextView) headerView.findViewById(R.id.tv_hero_name);
        }
    }
}
