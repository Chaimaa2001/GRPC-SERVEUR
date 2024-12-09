import app.grpc.User;
import app.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientGRPC {
    public static void main(String[] args) {
        ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost",9082).usePlaintext().build();
        userGrpc.userBlockingStub userStub=new userGrpc.userBlockingStub(channel);
        User.LoginRequest login=User.LoginRequest.newBuilder().setUserName("GRPC").setPassword("GRPC").build();
        User.LoginResponse response=userStub.login(login);
        System.out.println(response.getMsgResponse());
        channel.shutdown();
    }
}
