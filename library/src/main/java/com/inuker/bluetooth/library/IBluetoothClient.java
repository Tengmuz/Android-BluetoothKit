package com.inuker.bluetooth.library;

import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.inuker.bluetooth.library.connect.response.BleConnectResponse;
import com.inuker.bluetooth.library.connect.response.BleNotifyResponse;
import com.inuker.bluetooth.library.connect.response.BleReadResponse;
import com.inuker.bluetooth.library.connect.response.BleReadRssiResponse;
import com.inuker.bluetooth.library.connect.response.BleUnnotifyResponse;
import com.inuker.bluetooth.library.connect.response.BleWriteResponse;
import com.inuker.bluetooth.library.receiver.listener.BleConnectStatusChangeListener;
import com.inuker.bluetooth.library.receiver.listener.BluetoothStateChangeListener;
import com.inuker.bluetooth.library.search.SearchRequest;
import com.inuker.bluetooth.library.search.response.SearchResponse;

import java.util.UUID;

/**
 * Created by dingjikerbo on 2016/8/25.
 */
public interface IBluetoothClient {

    void connect(String mac, BleConnectOptions options, BleConnectResponse response);

    void disconnect(String mac);

    void registerConnectStatusListener(String mac, BleConnectStatusChangeListener listener);

    void unregisterConnectStatusListener(String mac, BleConnectStatusChangeListener listener);

    void read(String mac, UUID service, UUID character, BleReadResponse response);

    void write(String mac, UUID service, UUID character, byte[] value, BleWriteResponse response);

    void writeNoRsp(String mac, UUID service, UUID character, byte[] value, BleWriteResponse response);

    void notify(String mac, UUID service, UUID character, BleNotifyResponse response);

    void unnotify(String mac, UUID service, UUID character, BleUnnotifyResponse response);

    void indicate(String mac, UUID service, UUID character, BleNotifyResponse response);

    void unindicate(String mac, UUID service, UUID character, BleUnnotifyResponse response);

    void readRssi(String mac, BleReadRssiResponse response);

    void search(SearchRequest request, SearchResponse response);

    void stopSearch();

    void registerBluetoothStateListener(BluetoothStateChangeListener listener);

    void unregisterBluetoothStateListener(BluetoothStateChangeListener listener);
}
