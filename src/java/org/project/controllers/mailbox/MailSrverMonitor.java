/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.project.controllers.mailbox;

import com.sun.mail.imap.IMAPFolder;
import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.event.MessageCountAdapter;
import javax.mail.event.MessageCountEvent;
import javax.mail.search.FlagTerm;
import javax.servlet.ServletContext;

/**
 *
 * @author Eusuph
 */
/* Monitors given mailbox for new mail */
public class MailSrverMonitor implements Runnable {

    private static final String gmailAddress = "profqolo@gmail.com";
    private static final String password = "yusufcassim";
    private static final String host = "imap.gmail.com";
    private static final String hosts = "pop.gmail.com";
    private static final String directory = "C:\\Users\\Eusuph\\Desktop\\fileDownloader";
    private static final String port = "995";
    private static final int freq = 500000;
    ServletContext myServletContext;
    
    //private static String folderStr = "Inbox";

    @Override
    public void run() {
        System.out.println("\nTesting monitor\n");
        try {
            Properties props = System.getProperties();

            // Get a Session object
            Session session = Session.getInstance(props, null);
            System.out.println("***session deburg***");
            session.setDebug(true);

            // Get a Store object
            Store store = session.getStore("imaps");

			// Connect
            store.connect(host, gmailAddress, password);

            // Open a Folder
            Folder folder = store.getFolder("inbox");

            if (folder == null || !folder.exists()) {
                System.out.println("Invalid folder");
                System.exit(1);
            }

            folder.open(Folder.READ_WRITE);

            Message messages[] = folder.search(new FlagTerm(new Flags(
                    Flags.Flag.SEEN), false));
            System.out.println("No. of Unread Messages : " + messages.length);

            // Add messageCountListener to listen for new messages
            folder.addMessageCountListener(new MessageCountAdapter() {
                @Override
                public void messagesAdded(MessageCountEvent ev) {
                    Message[] msgs = ev.getMessages();
                    System.out.println("Got " + msgs.length + " new messages");
                                        //JOptionPane.showMessageDialog(null, "You have new mail from: !!",gmailAddress, JOptionPane.INFORMATION_MESSAGE);
                    // Just dump out the new messages
                    for (int i = 0; i < msgs.length; i++) {

                        try {
                            System.out.println("-----");
                            System.out.println("Message "
                                    + msgs[i].getMessageNumber() + ":");
//							msgs[i].writeTo(System.out);
                            System.out.println("Subject: " + msgs[i].getSubject());
                            System.out.println("From: " + msgs[i].getFrom()[0].toString());
                        } catch (MessagingException mex) {
                            mex.printStackTrace();
                        }
                    }

                }
            });

        EmailAttachmentDownload emailAttachmentDownload = new EmailAttachmentDownload(); 
        emailAttachmentDownload.setSaveDirectory(directory);
        emailAttachmentDownload.downloadEmailAttachments(hosts, port, gmailAddress, password);
            
            // Check mail once in "freq" MILLIseconds
            boolean supportsIdle = false;
            try {
                if (folder instanceof IMAPFolder) {
                    IMAPFolder f = (IMAPFolder) folder;
                    f.idle();
                    supportsIdle = true;
                }
            } catch (FolderClosedException fex) {
                fex.printStackTrace();
            } catch (MessagingException mex) {
                supportsIdle = false;
                mex.printStackTrace();
            }

            for (;;) {
                if (supportsIdle && folder instanceof IMAPFolder) {
                    IMAPFolder f = (IMAPFolder) folder;
                    f.idle();
                    System.out.println("IDLE done");
                    
                    
                } else {
                    Thread.sleep(freq); // sleep for freq milliseconds
                    folder.getMessageCount();
                }
            }
        } catch (InterruptedException | MessagingException ex) {
            
            ex.printStackTrace();
        }
        finally{
           
        }
        
    }

    MailSrverMonitor(ServletContext servletContext) {
        myServletContext = servletContext;
        
    }
}
