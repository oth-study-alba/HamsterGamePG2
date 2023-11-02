public class Map
{

   //----------------------------------------------------------------------
   //Variables
   String[][] room = {
                           {"▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓"},
                           {"▓▓▓", "   ", "   ", "   ", " ⚘ ", "▓▓▓", "   ", "   ", "   ", "▓▓▓"},
                           {"▓▓▓", "   ", "▓▓▓", "   ", "   ", "▓▓▓", "   ", "▓▓▓", "   ", "▓▓▓"},
                           {"▓▓▓", " ⚘ ", "▓▓▓", "   ", "   ", "▓▓▓", " ⚘ ", "▓▓▓", "   ", "▓▓▓"},
                           {"▓▓▓", "▓▓▓", "▓▓▓", "   ", "   ", "▓▓▓", "▓▓▓", "▓▓▓", "   ", "▓▓▓"},
                           {"▓▓▓", "▓▓▓", "   ", "   ", "   ", "   ", "   ", "   ", "   ", "▓▓▓"},
                           {"▓▓▓", " ⚘ ", "   ", "▓▓▓", "▓▓▓", "   ", "   ", "   ", " ⚘ ", "▓▓▓"},
                           {"▓▓▓", "   ", "   ", " ⚘ ", "▓▓▓", "   ", "▓▓▓", "   ", "   ", "▓▓▓"},
                           {"▓▓▓", "   ", "   ", "▓▓▓", "▓▓▓", "   ", " ⚘ ", "   ", "   ", "▓▓▓"},
                           {"▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓", "▓▓▓"},
                     };


   //----------------------------------------------------------------------
   //Methods
   public void renderRoom()
   {
      Player player = Player.getInstance();

      System.out.println("Hamster Munch      Score: " + player.getScore() + "/7 ");
      for (int i = 0; i < room.length; i++)
      {
         for (int j = 0; j < room[i].length; j++)
         {
            if ((player.getPlayerPositionX() == j) && (player.getPlayerPositionY() == i))
            {
               System.out.print(player.getSpirit());
            } else
            {
               System.out.print(room[i][j]);
            }
         }
         System.out.println();
      }
   }

   public void changeTile(int x, int y)
   {
      room[y][x] = "   ";
   }

   //----------------------------------------------------------------------
   //Getters and Setters
   public String getRoomTile(int x, int y)
   {
      return room[y][x];
   }

   //----------------------------------------------------------------------
   //SingletonConstructor
   private static Map INSTANCE;

   private Map() {}

   public static Map getInstance()
   {
      if (INSTANCE == null)
      {
         INSTANCE = new Map();
      }

      return INSTANCE;
   }


}