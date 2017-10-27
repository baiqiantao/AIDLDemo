package com.bqt.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyRemoteService extends Service {
	@Override
	public void onCreate() {
		Log.i("bqt", "onCreate");
		super.onCreate();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.i("bqt", "onBind");
		return new MyBinder();
	}
	
	@Override
	public void onRebind(Intent intent) {
		super.onRebind(intent);
		Log.i("bqt", "onRebind");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("bqt", "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		Log.i("bqt", "onUnbind");
		return super.onUnbind(intent);
	}
	
	@Override
	public void onDestroy() {
		Log.i("bqt", "onDestroy");
		super.onDestroy();
	}
	
	//******************************************************************************************
	
	/*这是服务里面的一个方法，对外是隐藏的，只能通过IBinder间接访问 */
	private void methodInService(int money) {
		Log.i("bqt", "服务里的方法被调用了……  " + money);
	}
	
	private class MyBinder extends IAidlBinderInterface.Stub {
		//由之前【extends Binder implements IBinderInterface】改为【extends IBinderInterface.Stub】
		@Override
		public boolean callMethodInService(int money) throws RemoteException {
			if (money >= 1) methodInService(money);//间接调用了服务中的方法
			else Log.i("bqt", "对不起，余额不足  " + money);
			return money >= 1;
		}
	}
}