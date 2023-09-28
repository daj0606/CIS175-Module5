// changed line 56 from original "l.getId() + " : " + l.toString()" because it was returning "51 : model.ListItem@669d2b1b"
import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a game: ");
			String game = in.nextLine();
			System.out.print("Enter a rank: ");
			String rank = in.nextLine();
			ListItem toAdd = new ListItem(game, rank);
			lih.InsertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the game to delete: ");
			String game = in.nextLine();
			System.out.print("Enter the rank to delete: ");
			String rank = in.nextLine();
			ListItem toDelete = new ListItem(game, rank);
			lih.deleteItem(toDelete);
		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Game");
			System.out.println("2 : Search by Rank");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListItem> foundItems;
			
			if (searchBy == 1) {
				System.out.print("Enter the game name: ");
				String gameName = in.nextLine();
				foundItems = lih.searchForRankByGame(gameName);
			} else {
				System.out.print("Enter the rank: ");
				String rankName = in.nextLine();
				foundItems = lih.searchForRankByRank(rankName);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					// changed from original "l.getId() + " : " + l.toString()" because it was returning "51 : model.ListItem@669d2b1b"
					System.out.println(l.getId() + " - " + l.returnItemDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForRankById(idToEdit);
				System.out.println("Retrieved " + toEdit.getRank() + " from " + toEdit.getGame());
				System.out.println("1 : Update Game");
				System.out.println("2 : Update Rank");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Game: ");
					String newGame = in.nextLine();
					toEdit.setGame(newGame);
				} else if (update == 2) {
					System.out.print("New Rank: ");
					String newRank = in.nextLine();
					toEdit.setRank(newRank);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to my rank viewer! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a game");
				System.out.println("*  2 -- Update a rank");
				System.out.println("*  3 -- Delete a game");
				System.out.println("*  4 -- View all games and ranks");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListItem> allItems = lih.showAllItems();
			
			for(ListItem singleItem : allItems) {
				// added "singleItem.getId()" to show item ID for more details
				System.out.println(singleItem.getId() + " - " + singleItem.returnItemDetails());
			}
			

		}

}