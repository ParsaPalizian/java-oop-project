package com.company.model;

import com.company.CustomArrayList;
import com.company.Result;
import com.company.dataadapter.AccountDataAdapter;
import com.company.dataadapter.FollowDataAdapter;
import com.company.dataadapter.PostDataAdapter;
import com.company.global.Globals;
import com.company.interfaces.Editable;
import com.company.interfaces.Printable;
import com.company.utility.PrintUtility;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Account implements Printable, Editable<Account> {

    private int id;
    private boolean business;
    private boolean isPrivate;


    private String firstName;
    private String lastName;
    private String userName;
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private String phoneNumber;
    private String email;
    private LocalDateTime registeredAt;
    private LocalDate birthday;
    private String password;
    private String forgetPasswordQuestion;
    private String forgetPasswordAnswer;
    private String bio;
    private CustomArrayList<ProfilePicture> profilePictures;
    private LocalDateTime lastLogin;
    private CustomArrayList<Follow> followings = new CustomArrayList<>(Follow::new);
    private CustomArrayList<Follow> followers = new CustomArrayList<>(Follow::new);
    private CustomArrayList<Group> groups;
    private CustomArrayList<Request> requests;
    private CustomArrayList<Post> posts;
    private CustomArrayList<Account> contacts;
    private CustomArrayList<PrivateMessage> privateMessages;
    private CustomArrayList<Block> blocklist;

    @Override
    public boolean equals(Object o) {
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void createContacts() {
        HashSet<Account> cntct = new HashSet<>();
        for (PrivateMessage privateMessage : this.getPrivateMessages()) {
            if (privateMessage.getSender().getId() != this.getId()) {
                cntct.add(privateMessage.getSender());
            }
            if (privateMessage.getReceiver().getId() != this.getId()) {
                cntct.add(privateMessage.getReceiver());
            }
        }
        this.contacts = new CustomArrayList<>(cntct, Account::new);

    }

    public CustomArrayList<PrivateMessage> getPrivateMessages() {
        if (privateMessages == null) {
            privateMessages = new CustomArrayList<>(PrivateMessage::new);
        }
        return privateMessages;
    }

    public void setPrivateMessages(CustomArrayList<PrivateMessage> privateMessages) {
        this.privateMessages = privateMessages;
    }

    public Account(String firstName, String lastName, String userName, String email, String password, String forgetPasswordQuestion, String forgetPasswordAnswer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public Account(String firstName, String lastName, String userName, String email, String password, String forgetPasswordQuestion, String forgetPasswordAnswer, String avatar) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;

    }

    public void changeAvatar() throws SQLException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        adapter.update(this);
    }

    public Account() {
    }

    public Account(int id) {
        this.id = id;
    }

    public CustomArrayList<Account> getContacts() {
        return contacts;
    }

    public void setContacts(CustomArrayList<Account> contacts) {
        this.contacts = contacts;
    }


    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public int getId() {
        return id;
    }

    public Account(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Account(int id, String userName, String avatar) {
        this.id = id;
        this.userName = userName;
        this.avatar = avatar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBusiness() {
        return business;
    }

    public void setBusiness(boolean business) {
        this.business = business;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getForgetPasswordQuestion() {
        return forgetPasswordQuestion;
    }

    public void setForgetPasswordQuestion(String forgetPasswordQuestion) {
        this.forgetPasswordQuestion = forgetPasswordQuestion;
    }

    public String getForgetPasswordAnswer() {
        return forgetPasswordAnswer;
    }

    public void setForgetPasswordAnswer(String forgetPasswordAnswer) {
        this.forgetPasswordAnswer = forgetPasswordAnswer;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<ProfilePicture> getProfilePictures() {
        if (profilePictures == null) {
            this.profilePictures = new CustomArrayList<>(ProfilePicture::new);
        }
        return profilePictures;
    }

    public void setProfilePictures(CustomArrayList<ProfilePicture> profilePictures) {
        this.profilePictures = profilePictures;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public CustomArrayList<Follow> getFollowings() {
        return followings;
    }

    public void setFollowings(CustomArrayList<Follow> followings) {
        this.followings = followings;
    }

    public CustomArrayList<Follow> getFollowers() {
        return followers;
    }

    public void setFollowers(CustomArrayList<Follow> followers) {
        this.followers = followers;
    }

    public CustomArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(CustomArrayList<Group> groups) {
        this.groups = groups;
    }

    public CustomArrayList<Request> getRequests() {
        if (requests == null) {
            requests = new CustomArrayList<>(Request::new);

        }
        return requests;
    }

    public void setRequests(CustomArrayList<Request> requests) {
        this.requests = requests;
    }

    public static Result<Request> sendRequest(Account from, Account to) throws SQLException {
        Request.request(from, to);

        Result<Request> result = new Result<Request>();
        result.setError(false);
        return result;
    }

    public CustomArrayList<Post> getPosts() {
        if (posts == null) {
            posts = new CustomArrayList<>(Post::new);
        }
        return posts;
    }

    public void setPosts(CustomArrayList<Post> posts) {
        this.posts = posts;
    }

    public CustomArrayList<Block> getBlocklist() {
        return blocklist;
    }

    public void setBlocklist(CustomArrayList<Block> blocklist) {
        this.blocklist = blocklist;
    }

    public static Account findById(int id) throws SQLException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        return adapter.findOne(id);

    }


    public static Result<Account> login(String userName, String password) throws Exception {

        AccountDataAdapter accountDataAdapter = new AccountDataAdapter();
        ArrayList<Account> accounts = accountDataAdapter.find(
                new String[]{"username", "password"},
                new String[]{userName, password}
        );
        if (accounts.size() == 0) {
            Globals.currentAccount = null;
        } else {
            Globals.loggedInAccount = accounts.get(0);
            Globals.currentAccount = Globals.loggedInAccount;
        }
        Result<Account> result = new Result();

        if (Globals.currentAccount == null) {
            result.setError(true);
            ArrayList<String> alerts = new ArrayList<>();
            alerts.add("Username Or Password is incorrect");
            result.setAlerts(alerts);
        } else {
            PostDataAdapter postDataAdapter = new PostDataAdapter();
            Globals.currentAccount.posts = postDataAdapter.find(new String[][]{{"account_id", Globals.currentAccount.getId() + ""}});
            Globals.currentAccount.followers = Follow.getFollowers(Globals.currentAccount);
            Globals.currentAccount.followings = Follow.getFollowings(Globals.currentAccount);
            Globals.currentAccount.groups = Group.getGroups(Globals.currentAccount);
            Globals.currentAccount.profilePictures = ProfilePicture.getProfilePictures(Globals.currentAccount);
            Globals.currentAccount.setPrivateMessages(PrivateMessage.getAllMessageBetweenUs(Globals.currentAccount).getData());
            Globals.currentAccount.setBlocklist(Block.getBlockedS(Globals.currentAccount));
            Globals.currentAccount.createContacts();
            Globals.currentAccount.requests = Request.getRequests(Globals.currentAccount).getData();
            Globals.historyAccounts = Account.loadHistory(Globals.currentAccount.getId()).getData();
        }

        return result;
    }

    public boolean logout() {
        return false;
    }

    public static Result signUp(String firstname, String lastName, String userName, String password, String email, String forgetPasswordQuestion, String forgetPasswordAnswer) throws Exception {
        AccountDataAdapter accountDataAdapter = new AccountDataAdapter();
        accountDataAdapter.insert(new Account(firstname, lastName, userName, email, password, forgetPasswordQuestion, forgetPasswordAnswer));

        return null;
    }


    public Result deReact(Post post) {
        return null;
    }

    public static Result post(Post post) {
        return null;
    }

    public static Result deleteComment(Comment comment) throws Exception {

        Comment.remove(comment.getId());
        Reaction.removeReactionForComment(comment.getId());
        Result result = new Result();
        result.setError(false);
        Comment deleteComment = new Comment();
        for (Comment comment1 : Globals.currentComments) {
            if (comment1.getId() == comment.getId()) {
                deleteComment = comment1;
            }
        }
        Globals.currentComments.remove(deleteComment);

        return result;
    }


    public static Result getPost(Account getter, Post post) {
        return null;
    }

//    public static Result follow(Follow follow) throws SQLException {
//        FollowDataAdapter followDataAdapter=new FollowDataAdapter();
//        followDataAdapter.insert(follow.getId());
//
//
//        Result result = new Result();
//        result.setError(false);
//        return result;
//    }

    public static Result unFollow(Follow follow) throws Exception {
        FollowDataAdapter followDataAdapter = new FollowDataAdapter();
        followDataAdapter.delete(follow.getId());


        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result updateFollower(int AccountId) {
        return null;
    }

    public static Result updateFollowings(int AccountId) {
        return null;
    }

    public static Result updateRequests(int AccountId) {
        return null;
    }

    public static Result confirmRequest(int AccountId, Request requests) {
        return null;
    }

    public static Result rejectRequest(int AccountId, Request requests) {
        return null;
    }

    public static Result block(Account blocker, Account blocked) throws SQLException {
        Block blck = new Block();
        blck.setBlocker(blocker);
        blck.setBlocked(blocked);
        Block.block(blck);

        Follow.unfollow(blocker, blocked);


        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result unBlock(Block block) throws Exception {
        Block.unblock(block);

        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result reportUser(int reporterId, int reportingId) {
        return null;
    }

    public static Result reportPost(int reporterId, int postId) {
        return null;
    }

    public static Result createGroup(Account admin, ArrayList<Account> accounts) {
        return null;
    }

    public static Result share(Account sharer, Post post, ArrayList<Account> receivers) {
        return null;
    }

    public static Result sendMessagePrivate(int AccountId, PrivateMessage message) {
        return null;
    }

    public static Result sendMessageGroup(int AccountId, PrivateMessage message) {
        return null;
    }

    public Result editProfile(
            String username, String password, String firstName, String lastName,
            String phoneNumber, String email, LocalDate birthday, String bio) throws SQLException {

        AccountDataAdapter accountDataAdapter = new AccountDataAdapter();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setUserName(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setPhoneNumber(phoneNumber);
        this.setBirthday(birthday);
        this.setBio(bio);
        accountDataAdapter.update(this);
        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result addNewUser(Account account) {
        return null;
    }

    public static Result deleteUser(int id) {
        return null;
    }

    public static Result editUser(Account account) {
        return null;
    }

    public static Result<CustomArrayList<Account>> searchAccount(String userName) throws SQLException, ParseException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        CustomArrayList<Account> accounts = adapter.search(userName);


        Result<CustomArrayList<Account>> result = new Result<>();
        result.setData(accounts);
        result.setError(false);
        return result;
    }


    public static boolean isUsernameExists(String username) throws Exception {
        AccountDataAdapter accountDataAdapter = new AccountDataAdapter();
        int cnt = accountDataAdapter.count(new String[]{"username"}, new String[]{username});
        return cnt != 0;
    }

    public static boolean isEmailExists(String email) throws Exception {
        AccountDataAdapter accountDataAdapter = new AccountDataAdapter();
        int cnt = accountDataAdapter.count(new String[]{"email"}, new String[]{email});
        return cnt != 0;
    }


    public Result<ProfilePicture> deleteProfilePicture(ProfilePicture mustBeDelete) throws Exception {
        Result<ProfilePicture> result = ProfilePicture.deleteProfilePicture(mustBeDelete);
        this.getProfilePictures().remove(mustBeDelete);
        return result;
    }

    public Result<ProfilePicture> AddProfilePicture(ProfilePicture profilePicture) throws Exception {
        Result<ProfilePicture> result = ProfilePicture.AddProfilePicture(profilePicture, this);
        this.getProfilePictures().add(profilePicture);

        result.setError(false);
        return result;
    }

    public static Result deleteGroupContent(GroupMessage groupMessage) throws Exception {
        GroupMessage.delete(groupMessage);
        Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getMessages().remove(groupMessage);
        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result saveHistory(int searcherId, int searchedId) throws SQLException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        adapter.saveSearch(searcherId, searchedId);

        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result kickMember(GroupMember groupMember) throws Exception {
        GroupMember.kick(groupMember);
        Globals.currentAccount.getGroups().get(Globals.currentGroupIndex).getGroupMembers().remove(Globals.currentMemberIndex);

        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result<CustomArrayList<Account>> loadHistory(int searcherId) throws SQLException, ParseException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        CustomArrayList<Account> accounts = adapter.loadHistory(searcherId);

        Result<CustomArrayList<Account>> result = new Result<>();
        result.setData(accounts);
        result.setError(false);
        return result;
    }

    public static Result leaveGroup(Account account, Group group) throws Exception {
        Group.leave(account, group);
        account.getGroups().remove(group);

        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result deleteGroup(Group group) throws Exception {
        Group.delete(group);
        Globals.currentAccount.getGroups().remove(Globals.currentGroupIndex);


        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result editGroupMessage(GroupMessage groupMessage) throws Exception {
        GroupMessage.edit(groupMessage);


        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result addFollower(Account follower, Account followed) throws SQLException {
        Result<Follow> followResult = Follow.follow(follower, followed);
        Globals.currentAccount.getFollowers().add(followResult.getData());

        Result result = new Result();
        result.setError(false);
        return result;
    }

    @Override
    public Result<Account> edit(String content, boolean... saveToDatabase) throws Exception {
        return null;
    }

    @Override
    public Result<Account> delete() throws Exception {
        return null;
    }

    @Override
    public void printEmptyMessage() {
        PrintUtility.printlnFail("No Account Found");
        PrintUtility.printlnCommands("(B)ack");
    }

    @Override
    public void printAtFirstPositionMessage() {
        PrintUtility.printlnFail("You Are On First Account");
    }

    @Override
    public void printAtLastPositionMessage() {
        PrintUtility.printlnFail("You Reached To Last Account");
    }

    @Override
    public void printContent() {
        PrintUtility.printAccount(this);
    }


    public Result<CustomArrayList<Account>> recommend(int wanted) throws SQLException, ParseException {

        AccountDataAdapter adapter = new AccountDataAdapter();
        CustomArrayList<Account> accounts = adapter.recommend(this.id, wanted, Globals.currentAccount.followings);
        Result<CustomArrayList<Account>> result = new Result<>();
        result.setData(accounts);
        result.setError(false);
        return result;

    }

    public static Result findBaseOnUserName(String userName) throws SQLException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        Account account = adapter.findBaseOnUserName(userName);

        Result result = new Result();
        result.setError(false);
        result.setData(account);
        return result;
    }

    public static Result updatePassword(Account account) throws SQLException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        adapter.update(account);

        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result updateIsBusiness(Account account) throws SQLException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        adapter.update(account);

        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result updateIsPrivate(Account account) throws SQLException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        adapter.update(account);

        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result clearSearchedHistory(Account account) throws SQLException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        adapter.clearSearchedHistory(account.getId());

        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result deleteFromSearchHistory(Account searcherAccount, Account searchedAccounts) throws SQLException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        adapter.deleteFromSearchHistory(searcherAccount.getId(), searchedAccounts.getId());


        Result result = new Result();
        result.setError(false);
        return result;
    }

    public static Result didAnswerMatch(Account account, String forgotPasswordAnswer) throws SQLException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        int count = adapter.count(new String[]{"account_id", "forgot_Password_Answer"}, new String[]{account.getId() + "", forgotPasswordAnswer});

        Result result = new Result();
        result.setError(false);
        result.setData(count);
        return result;
    }

    public static Account findByUsername(String userName) throws SQLException {
        AccountDataAdapter adapter = new AccountDataAdapter();
        return adapter.findOneByUsername(userName);

    }
}

