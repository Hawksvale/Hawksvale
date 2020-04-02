package net.hawksvale.src.api.inserts.townyrank;

import org.bukkit.entity.Player;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;

public class GetTownyRank {

	public static TownyRank getTownyRank(Player player) throws NotRegisteredException { 
		Resident resident = TownyAPI.getInstance().getDataSource().getResident(player.getName());
		if (resident.isKing())
			return TownyRank.KING;
		else if (resident.isMayor())
			return TownyRank.MAYOR;
		else if (resident.hasTown())
			return TownyRank.RESIDENT;
		else
			return TownyRank.WANDERER;
	}
	
}
