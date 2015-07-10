package net.jtk.darkroleplay.guis.hud;

import java.util.ArrayList;

import net.jtk.darkroleplay.main.Enums;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class Alignment {
	public static ArrayList getAlignment(RenderGameOverlayEvent event,Enums.Enum_GuiAlignment Alignment, int sizeX, int sizeY){
		ArrayList coords = new ArrayList();

		int posX,posY;

		switch(Alignment){
			case BOTTOM:
				posX = event.resolution.getScaledWidth() / 2 - (sizeX / 2);
				posY = event.resolution.getScaledHeight() - (sizeY);
			break;
		case LEFT:
			posX = 0;
			posY = event.resolution.getScaledHeight() / 2 - (sizeY / 2);
			break;
		case RIGHT:
			posX = event.resolution.getScaledWidth() - (sizeX);
			posY = event.resolution.getScaledHeight() / 2 - (sizeY/2);
			break;
		case TOP:
			posX = event.resolution.getScaledWidth()/2 - (sizeX/2);
			posY = 0;
			break;
		case CENTER:
			posX = event.resolution.getScaledWidth()/2 - (sizeX/2);
			posY = event.resolution.getScaledHeight()/2 - (sizeY/2);
			break;
		case TOPLEFT:
			posX = 0;
			posY = 0;
			break;
		case TOPRIGHT:
			posX = event.resolution.getScaledWidth() - sizeX;
			posY = 0;
			break;
		case BOTTOMLEFT:
			posX = 0;
			posY = event.resolution.getScaledHeight() - sizeY;
			break;
		case BOTTOMRIGHT:
			posX = event.resolution.getScaledWidth()- sizeX;
			posY = event.resolution.getScaledHeight()-sizeY;
			break;
		default:
			posX = event.resolution.getScaledWidth() / 2 -(sizeX /2);
			posY = event.resolution.getScaledHeight()-sizeY;
			break;
		}
		
		coords.add(posX);
		coords.add(posY);
		
		return  coords;
	}
}
