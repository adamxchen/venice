package com.linkedin.venice.blobtransfer;

import com.linkedin.venice.exceptions.StorePartitionNotFoundException;
import com.linkedin.venice.exceptions.VeniceNoStoreException;
import java.io.BufferedInputStream;
import java.util.concurrent.CompletionStage;


/**
 *
 * A BlobTransferManager is responsible for transferring blobs between two entities, either that Peer to Peer or node to
 * a blob store and vice versa. The underlying blob client is responsible for the actual transfer of the blob.
 * @param <T> the type of the object from the underlying blob client to indicate the upload status. It can be a blob ID
 *           indicating the blob has been uploaded or an enum representing the status of the blob transfer.
 */
public interface BlobTransferManager<T> extends AutoCloseable {
  /**
   * Start the blob transfer manager and related resources
   * @throws Exception
   */
  void start() throws Exception;

  /**
   * Get the blobs for the given storeName and partition
   * @param storeName
   * @param partition
   * @return the InputStream of the blob
   * @throws StorePartitionNotFoundException
   */
  CompletionStage<BufferedInputStream> get(String storeName, int partition) throws VeniceNoStoreException;

  /**
   * Put the blob for the given storeName and partition
   * @param storeName
   * @param partition
   * @return the type of the object returned from the underlying blob client to indicate the upload status
   */
  CompletionStage<T> put(String storeName, int partition);

  /**
   * Close the blob transfer manager and related resources
   */
  void close() throws Exception;
}