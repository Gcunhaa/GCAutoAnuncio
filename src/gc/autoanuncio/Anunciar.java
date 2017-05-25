package gc.autoanuncio;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Anunciar extends BukkitRunnable {
	
	private List<String> mensagens = null;
	private int ultimo = 0;
	Anunciar(List<String> m){
		this.mensagens = m;
	}
	
	@Override
	public void run() {
		if(!mensagens.isEmpty()){
			int nmsg = mensagens.size();
			Random rn = new Random();
			int intmsg = rn.nextInt(nmsg);
			while(intmsg == ultimo){
				intmsg = rn.nextInt(nmsg);
			}
			this.ultimo = intmsg;
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage(mensagens.get(intmsg).replace("&", "§"));
			Bukkit.broadcastMessage("");
		};
		
	}
	
	

}
