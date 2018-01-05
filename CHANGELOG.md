

## CURRENT
* RESKC-869: Fix broken IT
  * Jeff Largent on Fri, 5 Jan 2018 15:11:36 -0500 [View Commit](../../commit/9dda734cdf1656d172f78062c9c1bc79c427540d)
* RESKC-1748: Unify award report tracking sync behavior

* No longer regenerate tracking entries with Pending status on every save
* Always regenerate schedules for both `REGEN` and `ADDONLY` frequency bases, preserving trackings with dates that match the new schedule
  * Jeff Largent on Fri, 5 Jan 2018 12:32:58 -0500 [View Commit](../../commit/3f7b06f7566b247f69cbebc696e59a2aac106bfd)
* RESKC-869: Store award ID with award report tracking entries

* Also updated report tracking lookup to only return entries associated with `ACTIVE` or `PENDING` awards
* Included script to re-map existing report tracking entries to the award terms associated with the latest award version
  * Jeff Largent on Fri, 5 Jan 2018 12:24:52 -0500 [View Commit](../../commit/37e771ee9b066fc541a2bb8c39952adbf05feecd)

## coeus-1801.0006
* RESKC-2688: Adding NSF ID field (#2693)

  * To support the upcoming NSF changes, add the new NSF ID field to the Extended Attributes (near the NIH ERA Commons ID)
  * Please add a display field for the NSF in the Key Personnel page, again near the ERA Commons field, and automatically fill this when the person is added.  * Gayathri Athreya on Thu, 4 Jan 2018 14:10:31 -0700 [View Commit](../../commit/e60064093b5eba98c60b402655856c959fb709c1)

## coeus-1801.0005
* RESKC-2694: implement workaround for User Attached Form: Human Studies Clinical Trial form with Human Studies attachment
  * Travis Schneeberger on Wed, 3 Jan 2018 16:47:24 -0500 [View Commit](../../commit/ba24f85dde9e2df2bb8f204a43c862cb3b3cccde)

## coeus-1801.0004
* RESKC-2232: Enabling notifications (#2692)

  * Steps to Reproduce
  * Create an award with basic information to submit/finalize
  * Add a property report with a due date in the past
submit award
  * Actual Result
  * No notification is sent out to the persons listed on the notification document.
  * Expected Result
  * The system should generate emails/action list items triggered off of the events specified in the notifications table. (Ex: Property report Overdue) It looks like the triggers are not in place for these to be sending.  * Gayathri Athreya on Thu, 4 Jan 2018 08:36:37 -0700 [View Commit](../../commit/e0785791544819a67a7f1334eed86ec94f3205ac)

## coeus-1801.0003
* RESKC-2467: Copy recipients list in tag file to avoid ConcurrentModificationException
  * Jeff Largent on Tue, 2 Jan 2018 15:53:55 -0500 [View Commit](../../commit/5c093231823f0f938c4e933bb3a66514671e3137)

## coeus-1801.0002
* RESKC-2293: Reducing length of field to match db (#2689)

  * Gayathri Athreya on Tue, 2 Jan 2018 10:57:03 -0700 [View Commit](../../commit/e9e7b824883cd1e0a7814cd7a10bcaa80a83dd4e)

## coeus-1801.0001
* RESKC-2290: Add filter to set caching headers on static resources
  * Jeff Largent on Tue, 2 Jan 2018 10:36:24 -0500 [View Commit](../../commit/7d9aba95b6e798244e8f21739d2cf2b91a12f4b1)