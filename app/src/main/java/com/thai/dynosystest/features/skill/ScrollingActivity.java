package com.thai.dynosystest.features.skill;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.thai.dynosystest.R;
import com.thai.dynosystest.SaveData;
import com.thai.dynosystest.features.detail.DetailActivity;
import com.thai.dynosystest.model.Hero;
import com.thai.dynosystest.model.Skill;
import com.thai.dynosystest.utils.ImageUtils;
import com.thai.dynosystest.utils.Utils;

import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private ScrollingActivity.SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private RecyclerView rvSkill;
    private SkillsAdapter skillsAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Skill> skills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Utils.saveDeviceSize(this);

        //setupFakeData
        setupFakeData();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new ScrollingActivity.SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // Disable clip to padding
        mViewPager.setClipToPadding(false);
        // set padding manually, the more you set the padding the more you see of prev & next page
        mViewPager.setPadding(0, 0, 340, 0);
        // sets a margin b/w individual pages to ensure that there is a gap b/w them
        mViewPager.setPageMargin(20);

        mViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float position) {
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                int pageWidth = view.getWidth();
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_hero);
                imageView.setBackgroundColor(Color.TRANSPARENT);
                if (position < -1) {
                    // [-00,-1): the page is way off-screen to the left.
                } else if (position < 0) {
                    // [-1,1]: the page is "centered"
                    view.setTranslationX(-60 * normalizedposition * normalizedposition);
                } else if (position == 0) {
                    Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                    bitmap = ImageUtils.blur(getApplicationContext(), bitmap);
                    BitmapDrawable ob = new BitmapDrawable(getResources(), bitmap);
                    ob.setAlpha(200);
                    imageView.setBackground(ob);
                    view.setTranslationX(0);
                } else if (position < 1) {
//                    view.setTranslationX(-60 * normalizedposition * normalizedposition);

                } else {
                    // (1,+00]: the page is way off-screen to the right.
                }
            }

        });

        setupBody();

        setUpViewPagerScroll();
    }

    private void setUpViewPagerScroll() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 1:
                        skills.clear();
                        skills.addAll(lichSkill);
                        skillsAdapter.updateData(skills);
                        break;
                    case 2:
                        skills.clear();
                        skills.addAll(sandKingSkill);
                        skillsAdapter.updateData(skills);
                        break;
                    default:
                        skills.clear();
                        skills.addAll(phantomSkill);
                        skillsAdapter.updateData(skills);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    //region FAKE_DATE
    ArrayList<Skill> phantomSkill;
    ArrayList<Skill> lichSkill;
    ArrayList<Skill> sandKingSkill;

    private void setupFakeData() {
        phantomAssassin();
        lich();
        sandKing();
    }

    private void sandKing() {
        sandKingSkill = new ArrayList<>();
        //Create empty skill for header
        sandKingSkill.add(new Skill());
        sandKingSkill.add(new Skill(R.drawable.sand_king_1, getString(R.string.sand_king_1_name), getString(R.string.sand_king_1)));
        sandKingSkill.add(new Skill(R.drawable.sand_king_2, getString(R.string.sand_king_2_name), getString(R.string.sand_king_2)));
        sandKingSkill.add(new Skill(R.drawable.sand_king_3, getString(R.string.sand_king_3_name), getString(R.string.sand_king_3)));
        sandKingSkill.add(new Skill(R.drawable.sand_king_4, getString(R.string.sand_king_4_name), getString(R.string.sand_king_4)));
    }

    private void lich() {
        lichSkill = new ArrayList<>();
        //Create empty skill for header
        lichSkill.add(new Skill());
        lichSkill.add(new Skill(R.drawable.lich_1, getString(R.string.lich_1_name), getString(R.string.lich_1)));
        lichSkill.add(new Skill(R.drawable.lich_2, getString(R.string.lich_2_name), getString(R.string.lich_2)));
        lichSkill.add(new Skill(R.drawable.lich_3, getString(R.string.lich_3_name), getString(R.string.lich_3)));
        lichSkill.add(new Skill(R.drawable.lich_4, getString(R.string.lich_4_name), getString(R.string.lich_4)));
    }

    private void phantomAssassin() {
        phantomSkill = new ArrayList<>();
        //Create empty skill for header
        phantomSkill.add(new Skill());
        phantomSkill.add(new Skill(R.drawable.phantom_1, getString(R.string.phantom_1_name), getString(R.string.phantom_1)));
        phantomSkill.add(new Skill(R.drawable.phantom_2, getString(R.string.phantom_2_name), getString(R.string.phantom_2)));
        phantomSkill.add(new Skill(R.drawable.phantom_3, getString(R.string.phantom_3_name), getString(R.string.phantom_3)));
        phantomSkill.add(new Skill(R.drawable.phantom_4, getString(R.string.phantom_4_name), getString(R.string.phantom_4)));
    }

    //endregion

    /**
     * Init setup for the scroll body of main view
     */
    private void setupBody() {
        rvSkill = (RecyclerView) findViewById(R.id.rv_skill);
        skillsAdapter = new SkillsAdapter(this, skills, R.layout.item_skill, R.layout.item_skill_header);
        linearLayoutManager = new LinearLayoutManager(this);
        skills = new ArrayList<>();
        //add phantom skill for first view
        skills.clear();
        skills.addAll(phantomSkill);
        skillsAdapter.updateData(skills);
        rvSkill.setLayoutManager(linearLayoutManager);
        rvSkill.setAdapter(skillsAdapter);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String HERO_NAME = "heroName";
        private static final String HERO_TYPE = "heroType";
        private static final String HERO_IMAGE = "heroImage";
        private static final String HERO_TYPE_IMAGE = "heroTypeImage";
        private static final String HERO_STORY = "heroStory";

        private ArrayList<Hero> heros;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static ScrollingActivity.PlaceholderFragment newInstance(String heroName, String heroType, int heroImage, int heroTypeImage, String heroStory) {
            ScrollingActivity.PlaceholderFragment fragment = new ScrollingActivity.PlaceholderFragment();
            Bundle args = new Bundle();
            args.putString(HERO_NAME, heroName);
            args.putString(HERO_TYPE, heroType);
            args.putInt(HERO_IMAGE, heroImage);
            args.putInt(HERO_TYPE_IMAGE, heroTypeImage);
            args.putString(HERO_STORY, heroStory);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView tvName = (TextView) rootView.findViewById(R.id.tv_name);
            TextView tvType = (TextView) rootView.findViewById(R.id.tv_type);
            final ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_hero);
            ImageView ivType = (ImageView) rootView.findViewById(R.id.iv_hero_type);
            LinearLayout llHeroName = (LinearLayout) rootView.findViewById(R.id.ll_hero_name);
            changeImageSize(imageView);
            changellHeroNameSize(llHeroName);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), DetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt(DetailActivity.HERO_IMAGE, getArguments().getInt(HERO_IMAGE));
                    bundle.putString(DetailActivity.HERO_NAME, getArguments().getString(HERO_NAME));
                    bundle.putString(DetailActivity.HERO_TYPE, getArguments().getString(HERO_TYPE));
                    bundle.putString(DetailActivity.HERO_STORY, getArguments().getString(HERO_STORY));
                    intent.putExtras(bundle);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(getActivity(), imageView, "heroImage");
                    startActivity(intent, options.toBundle());
                }
            });
            tvName.setText(getArguments().getString(HERO_NAME));
            imageView.setImageResource(getArguments().getInt(HERO_IMAGE));
            ivType.setImageResource(getArguments().getInt(HERO_TYPE_IMAGE));
            tvType.setText(getArguments().getString(HERO_TYPE));
            return rootView;
        }

        private void changellHeroNameSize(LinearLayout llHeroName) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) llHeroName.getLayoutParams();
            params.width = SaveData.getInstance(getContext()).getDeviceWidth() / 5 * 3;
            llHeroName.setLayoutParams(params);
        }

        private void changeImageSize(ImageView imageView) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            params.height = SaveData.getInstance(getContext()).getDeviceHeight() / 2;
            params.width = SaveData.getInstance(getContext()).getDeviceWidth() / 5 * 3;
            imageView.setLayoutParams(params);
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Hero hero = null;
            switch (position) {
                case 0:
                    hero = new Hero("PHANTOM ASSASSIN", "Melee - Carry - Escape", R.drawable.phantom_avatar, R.drawable.ic_agility, getString(R.string.phantom_story));
                    break;
                case 1:
                    hero = new Hero("LICH", "Ranged - Support - Nuker", R.drawable.lich_avatar, R.drawable.ic_intelligence, getString(R.string.lich_story));
                    break;
                case 2:
                    hero = new Hero("SAND KING", "Melee - Initiator - Disabler", R.drawable.sand_king_avatar, R.drawable.ic_strenght, getString(R.string.sand_king_story));
                    break;
            }
            return ScrollingActivity.PlaceholderFragment.newInstance(hero.getHeroName(), hero.getHeroType(), hero.getHeroImage(), hero.getHeroTypeImage(), hero.getHeroStory());
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
