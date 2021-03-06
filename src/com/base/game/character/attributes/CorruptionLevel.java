package com.base.game.character.attributes;

import com.base.game.character.effects.StatusEffect;
import com.base.utils.Colour;

/**
 * @since 0.1.65
 * @version 0.1.79
 * @author Innoxia
 */
public enum CorruptionLevel {

	/**A character at this level: Will not want any sexual relations with anyone but the person they love.*/
	ZERO_PURE("pure", 0, 5, Colour.CORRUPTION_STAGE_ZERO, 0) {
		@Override
		public StatusEffect getRelatedStatusEffect() {
			return StatusEffect.CORRUPTION_PERK_0;
		}

		@Override
		public boolean isAbleToPerformCorruptiveAction(CorruptionLevel action) {
			switch(action){
				case ZERO_PURE:
						return true;
				case ONE_VANILLA:
						return true;
				case TWO_HORNY:
						return true;
				case THREE_DIRTY:
						return false;
				case FOUR_LUSTFUL:
						return false;
				case FIVE_CORRUPT:
						return false;
				default:
						return false;
			}
		}
	},
	/**A character at this level: Will be open to the idea of having multiple sexual partners, and will be willing to have sex with defeated enemies. Their in-sex options will be limited, however, to quite vanilla acts.*/
	ONE_VANILLA("vanilla", 5, 15, Colour.CORRUPTION_STAGE_ONE, 0.1f) {
		@Override
		public StatusEffect getRelatedStatusEffect() {
			return StatusEffect.CORRUPTION_PERK_1;
		}

		@Override
		public boolean isAbleToPerformCorruptiveAction(CorruptionLevel action) {
			switch(action){
				case ZERO_PURE:
						return true;
				case ONE_VANILLA:
						return true;
				case TWO_HORNY:
						return true;
				case THREE_DIRTY:
						return true;
				case FOUR_LUSTFUL:
						return false;
				case FIVE_CORRUPT:
						return false;
				default:
						return false;
			}
		}
	},
	/**A character at this level: Will have sex with pretty much anything, but won't do anything too crazy.*/
	TWO_HORNY("horny", 15, 35, Colour.CORRUPTION_STAGE_TWO, 0.25f) {
		@Override
		public StatusEffect getRelatedStatusEffect() {
			return StatusEffect.CORRUPTION_PERK_2;
		}

		@Override
		public boolean isAbleToPerformCorruptiveAction(CorruptionLevel action) {
			switch(action){
				case ZERO_PURE:
						return true;
				case ONE_VANILLA:
						return true;
				case TWO_HORNY:
						return true;
				case THREE_DIRTY:
						return true;
				case FOUR_LUSTFUL:
						return true;
				case FIVE_CORRUPT:
						return false;
				default:
						return false;
			}
		}
	},
	/**A character at this level: This is where the character starts to really lose themselves to corruption. Rough sex.*/
	THREE_DIRTY("dirty", 35, 65, Colour.CORRUPTION_STAGE_THREE, 0.5f) {
		@Override
		public StatusEffect getRelatedStatusEffect() {
			return StatusEffect.CORRUPTION_PERK_3;
		}

		@Override
		public boolean isAbleToPerformCorruptiveAction(CorruptionLevel action) {
			return true;
		}
	},
	/**A character at this level: A complete sex fiend. Will do anything, with anyone, anywhere and anyhow.*/
	FOUR_LUSTFUL("lustful", 65, 95, Colour.CORRUPTION_STAGE_FOUR, 1f) {
		@Override
		public StatusEffect getRelatedStatusEffect() {
			return StatusEffect.CORRUPTION_PERK_4;
		}

		@Override
		public boolean isAbleToPerformCorruptiveAction(CorruptionLevel action) {
			return true;
		}
	},
	/**A character at this level: Is completely lost to corruption.*/
	FIVE_CORRUPT("corrupt", 95, 100, Colour.CORRUPTION_STAGE_FIVE, 2f) {
		@Override
		public StatusEffect getRelatedStatusEffect() {
			return StatusEffect.CORRUPTION_PERK_5;
		}

		@Override
		public boolean isAbleToPerformCorruptiveAction(CorruptionLevel action) {
			return true;
		}
	};
	
	
	
	
	private String name;
	private int minimumValue, maximumValue;
	private Colour colour;
	private float corruptionBypass;

	private CorruptionLevel(String name, int minimumValue, int maximumValue, Colour colour, float corruptionBypass) {
		this.name = name;
		this.minimumValue = minimumValue;
		this.maximumValue = maximumValue;
		this.colour = colour;
		this.corruptionBypass=corruptionBypass;
	}
	
	public abstract StatusEffect getRelatedStatusEffect();
	
	public abstract boolean isAbleToPerformCorruptiveAction(CorruptionLevel action);

	public String getName() {
		return name;
	}

	public int getMinimumValue() {
		return minimumValue;
	}

	public int getMaximumValue() {
		return maximumValue;
	}

	public Colour getColour() {
		return colour;
	}
	
	public float getCorruptionBypass() {
		return corruptionBypass;
	}
	
	public static CorruptionLevel getCorruptionLevelFromValue(float value){
		for(CorruptionLevel al : CorruptionLevel.values()) {
			if(value>=al.getMinimumValue() && value<al.getMaximumValue())
				return al;
		}
		return FIVE_CORRUPT;
	}
}
