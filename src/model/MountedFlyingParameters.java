package model;

public class MountedFlyingParameters {

    private String type = "pixelmon:default";
    private int upper_angle_limit, lower_angle_limit, max_fly_speed, strafe_roll_conversion, turn_rate, pitch_rate,
            continuous_forward_motion_ticks,
            flying_stamina_charges, hover_ticks;
    private double deceleration_rate, hover_deceleration_rate, acceleration_rate, strafe_acceleration_rate,
            gravity_drop_per_tick;
    private boolean stays_horizontal_flying, continuous_forward_motion;

    public MountedFlyingParameters() {
    }

    public MountedFlyingParameters(String type, int upper_angle_limit, int lower_angle_limit, int max_fly_speed,
            int strafe_roll_conversion, int turn_rate, int pitch_rate, int continuous_forward_motion_ticks,
            int flying_stamina_charges, int hover_ticks, double deceleration_rate, double hover_deceleration_rate,
            double acceleration_rate, double strafe_acceleration_rate, double gravity_drop_per_tick,
            boolean stays_horizontal_flying, boolean continuous_forward_motion) {
        this.type = type;
        this.upper_angle_limit = upper_angle_limit;
        this.lower_angle_limit = lower_angle_limit;
        this.max_fly_speed = max_fly_speed;
        this.strafe_roll_conversion = strafe_roll_conversion;
        this.turn_rate = turn_rate;
        this.pitch_rate = pitch_rate;
        this.continuous_forward_motion_ticks = continuous_forward_motion_ticks;
        this.flying_stamina_charges = flying_stamina_charges;
        this.hover_ticks = hover_ticks;
        this.deceleration_rate = deceleration_rate;
        this.hover_deceleration_rate = hover_deceleration_rate;
        this.acceleration_rate = acceleration_rate;
        this.strafe_acceleration_rate = strafe_acceleration_rate;
        this.gravity_drop_per_tick = gravity_drop_per_tick;
        this.stays_horizontal_flying = stays_horizontal_flying;
        this.continuous_forward_motion = continuous_forward_motion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUpper_angle_limit() {
        return upper_angle_limit;
    }

    public void setUpper_angle_limit(int upper_angle_limit) {
        this.upper_angle_limit = upper_angle_limit;
    }

    public int getLower_angle_limit() {
        return lower_angle_limit;
    }

    public void setLower_angle_limit(int lower_angle_limit) {
        this.lower_angle_limit = lower_angle_limit;
    }

    public int getMax_fly_speed() {
        return max_fly_speed;
    }

    public void setMax_fly_speed(int max_fly_speed) {
        this.max_fly_speed = max_fly_speed;
    }

    public int getStrafe_roll_conversion() {
        return strafe_roll_conversion;
    }

    public void setStrafe_roll_conversion(int strafe_roll_conversion) {
        this.strafe_roll_conversion = strafe_roll_conversion;
    }

    public int getTurn_rate() {
        return turn_rate;
    }

    public void setTurn_rate(int turn_rate) {
        this.turn_rate = turn_rate;
    }

    public int getPitch_rate() {
        return pitch_rate;
    }

    public void setPitch_rate(int pitch_rate) {
        this.pitch_rate = pitch_rate;
    }

    public int getContinuous_forward_motion_ticks() {
        return continuous_forward_motion_ticks;
    }

    public void setContinuous_forward_motion_ticks(int continuous_forward_motion_ticks) {
        this.continuous_forward_motion_ticks = continuous_forward_motion_ticks;
    }

    public int getFlying_stamina_charges() {
        return flying_stamina_charges;
    }

    public void setFlying_stamina_charges(int flying_stamina_charges) {
        this.flying_stamina_charges = flying_stamina_charges;
    }

    public int getHover_ticks() {
        return hover_ticks;
    }

    public void setHover_ticks(int hover_ticks) {
        this.hover_ticks = hover_ticks;
    }

    public double getDeceleration_rate() {
        return deceleration_rate;
    }

    public void setDeceleration_rate(double deceleration_rate) {
        this.deceleration_rate = deceleration_rate;
    }

    public double getHover_deceleration_rate() {
        return hover_deceleration_rate;
    }

    public void setHover_deceleration_rate(double hover_deceleration_rate) {
        this.hover_deceleration_rate = hover_deceleration_rate;
    }

    public double getAcceleration_rate() {
        return acceleration_rate;
    }

    public void setAcceleration_rate(double acceleration_rate) {
        this.acceleration_rate = acceleration_rate;
    }

    public double getStrafe_acceleration_rate() {
        return strafe_acceleration_rate;
    }

    public void setStrafe_acceleration_rate(double strafe_acceleration_rate) {
        this.strafe_acceleration_rate = strafe_acceleration_rate;
    }

    public double getGravity_drop_per_tick() {
        return gravity_drop_per_tick;
    }

    public void setGravity_drop_per_tick(double gravity_drop_per_tick) {
        this.gravity_drop_per_tick = gravity_drop_per_tick;
    }

    public boolean isStays_horizontal_flying() {
        return stays_horizontal_flying;
    }

    public void setStays_horizontal_flying(boolean stays_horizontal_flying) {
        this.stays_horizontal_flying = stays_horizontal_flying;
    }

    public boolean isContinuous_forward_motion() {
        return continuous_forward_motion;
    }

    public void setContinuous_forward_motion(boolean continuous_forward_motion) {
        this.continuous_forward_motion = continuous_forward_motion;
    }
}
