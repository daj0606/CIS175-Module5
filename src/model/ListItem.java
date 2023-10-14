package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// was going to try to fix "@GeneratedValue" because it is auto generating values by adding 50 to the current id (1, 51, 101, 151)
// I realized it would be complicated though and I do not believe that it is going to break anything. But would be good to know how to fix in future

@Entity
@Table(name="games")
public class ListItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="GAME")
	private String game;
	@Column(name="CURRENTRANK")
	private String rank;
	
	public ListItem() {
		super();
	}
	
	public ListItem(String game, String rank) {
		super();
		this.game = game;
		this.rank = rank;
	}
	
	public String returnItemDetails() {
		return this.game + ":" + this.rank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "ListItem [id=" + id + ", game=" + game + ", rank=" + rank + "]";
	}
	
}
