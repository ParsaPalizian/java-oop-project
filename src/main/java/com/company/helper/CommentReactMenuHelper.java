package com.company.helper;

import com.company.Result;
import com.company.enums.ReactionType;
import com.company.global.Globals;
import com.company.model.Reaction;
import com.company.utility.PrintUtility;

public class CommentReactMenuHelper {
    public static void printReact() {
        PrintUtility.createEmojisMenu();
    }

    public static void performReactCommand(String command) {
        try {
            int intComm = Integer.parseInt(command);
            Result result = null;
            switch (intComm) {

                case 1:
                    result = Reaction.react(Globals.currentAccount, new Reaction(ReactionType.LAUGH), Globals.currentComments.current());
//                    Globals.currentComments.get(Globals.currentTimelinePostIndex).getReactions().add((Reaction) result.getData());
                    Globals.menuLevels.pop();
                    break;
                case 2:
                    result = Reaction.react(Globals.currentAccount, new Reaction(ReactionType.HEART), Globals.currentComments.current());
//                    Globals.currentComments.get(Globals.currentTimelinePostIndex).getReactions().add((Reaction) result.getData());
                    Globals.menuLevels.pop();
                    break;

                case 3:
                    result = Reaction.react(Globals.currentAccount, new Reaction(ReactionType.LIKE), Globals.currentComments.current());
//                    Globals.currentComments.get(Globals.currentTimelinePostIndex).getReactions().add((Reaction) result.getData());
                    Globals.menuLevels.pop();
                    break;

                case 4:
                    result = Reaction.react(Globals.currentAccount, new Reaction(ReactionType.DISLIKE), Globals.currentComments.current());
//                    Globals.currentComments.get(Globals.currentTimelinePostIndex).getReactions().add((Reaction) result.getData());
                    Globals.menuLevels.pop();
                    break;

                case 5:
                    result = Reaction.react(Globals.currentAccount, new Reaction(ReactionType.POKER_FACE), Globals.currentComments.current());
//                    Globals.currentComments.get(Globals.currentTimelinePostIndex).getReactions().add((Reaction) result.getData());
                    Globals.menuLevels.pop();
                    break;

                case 6:
                    result = Reaction.react(Globals.currentAccount, new Reaction(ReactionType.RAGE), Globals.currentComments.current());
//                    Globals.currentComments.get(Globals.currentTimelinePostIndex).getReactions().add((Reaction) result.getData());
                    Globals.menuLevels.pop();
                    break;

                case 7:
                    result = Reaction.react(Globals.currentAccount, new Reaction(ReactionType.CRY), Globals.currentComments.current());
//                    Globals.currentComments.get(Globals.currentTimelinePostIndex).getReactions().add((Reaction) result.getData());
                    Globals.menuLevels.pop();
                    break;

                case 8:
                    result = Reaction.react(Globals.currentAccount, new Reaction(ReactionType.DISGUSTING), Globals.currentComments.current());
//                    Globals.currentComments.get(Globals.currentTimelinePostIndex).getReactions().add((Reaction) result.getData());
                    Globals.menuLevels.pop();
                    break;

                case 9:
                    result = Reaction.react(Globals.currentAccount, new Reaction(ReactionType.FIRE), Globals.currentComments.current());
//                    Globals.currentComments.get(Globals.currentTimelinePostIndex).getReactions().add((Reaction) result.getData());
                    Globals.menuLevels.pop();
                    break;

                case 0:
                    Globals.menuLevels.pop();

            }

        } catch (Exception ex) {
            PrintUtility.printlnFail("Please Enter Correct Number");
        }
    }
}