package model;

import model.ModelLocator.ModelLocator;

import java.util.ArrayList;

public class Palette {
    private String name;
    private String texture;
    private String sprite;
    private String particle;
    private String emissive;
    private String normalMap;
    private String translationKey;
    private ModelLocator modelLocator;
    private ModelLocator flyingModelLocator;

    private ArrayList<String> sounds;

    public Palette() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getParticle() {
        return particle;
    }

    public void setParticle(String particle) {
        this.particle = particle;
    }

    public ModelLocator getModelLocator() {
        return modelLocator;
    }

    public void setModelLocator(ModelLocator modelLocator) {
        this.modelLocator = modelLocator;
    }

    public String getEmissive() {
        return emissive;
    }

    public void setEmissive(String emissive) {
        this.emissive = emissive;
    }

    public String getNormalMap() {
        return normalMap;
    }

    public void setNormalMap(String normalMap) {
        this.normalMap = normalMap;
    }

    public String getTranslationKey() {
        return translationKey;
    }

    public void setTranslationKey(String translationKey) {
        this.translationKey = translationKey;
    }

    public ModelLocator getFlyingModelLocator() {
        return flyingModelLocator;
    }

    public void setFlyingModelLocator(ModelLocator flyingModelLocator) {
        this.flyingModelLocator = flyingModelLocator;
    }

    public ArrayList<String> getSounds() {
        return sounds;
    }

    public void setSounds(ArrayList<String> sounds) {
        this.sounds = sounds;
    }

    @Override
    public String toString() {
        return "palette {" +
                "name='" + name + '\'' +
                ", texture='" + texture + '\'' +
                ", sprite='" + sprite + '\'' + ", particle='" + particle + '\'' +
                ((modelLocator != null) ? ", modelLocator=" + modelLocator : "") +
                ((flyingModelLocator != null) ? ", flyingModelLocator=" + flyingModelLocator : "") +
                ((sounds != null) ? ", sounds=" + sounds : "") +
                '}';
    }
}