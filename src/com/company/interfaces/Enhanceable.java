package com.company.interfaces;

import com.company.game.objects.enhancements.Enhancement;

import java.util.List;

/**
 * Created by RoYaL on 8/5/2015.
 */
public interface Enhanceable {

    public List<Enhancement> getEnhancements();

    public void addEnhancement(Enhancement enhancement);

}
