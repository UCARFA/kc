

## CURRENT
* No Changes


## coeus-1801.0026
* RESKC-2723: making attachments optional for Other Project Information form 1.3 and 1.4
  * Travis Schneeberger on Thu, 18 Jan 2018 11:54:54 -0500 [View Commit](../../commit/594d56170c040817be0000b096e0f855ca236cdf)

## coeus-1801.0025
* RESKC-2090: Revert fix (#2714)

  * Gayathri Athreya on Wed, 17 Jan 2018 12:30:09 -0700 [View Commit](../../commit/b55b3a1ac52d73f0e59129621b075deb201c4c51)

## coeus-1801.0024
* No Changes


## coeus-1801.0023
* Copyright intelli j (#2712)

* RESKC-2703: xml files
  * 
* RESKC-2703: Java and js files
  * 
* RESKC-2703: More files with different type of copyright
  * 
* RESKC-2703: Mild changes to right header and more java changes
  * 
* RESKC-2703: xsl and more xml
  * 
* RESKC-2703: Other miscellaneous comment types
  * 
* RESKC-2703: License update
  * 
* RESKC-2703: Changing license in pom
  * Gayathri Athreya on Tue, 16 Jan 2018 08:19:14 -0700 [View Commit](../../commit/34c042268acf79792d4d39d7a87aa942f000b06a)

## coeus-1801.0022
* RESKC-2653: Adding attachment 1 (#2708)

  * Gayathri Athreya on Fri, 12 Jan 2018 15:32:06 -0700 [View Commit](../../commit/e704eb7bf183b5904290831542eaaa1c5310eea3)

## coeus-1801.0021
* RESKC-2715: Fix ART notification integration test
  * Jeff Largent on Fri, 12 Jan 2018 16:27:44 -0500 [View Commit](../../commit/2b5d5a9ee5a6e332b8fb82de2841fb6316af6a7f)
* RESKC-2715: Base Award Report Tracking sent notifications records on report class and code rather than tying them to a specific term ID (#2709)

* Changed report tracking notifications to avoid sending duplicates based on report class and code rather than term ID
* Included maintenance screen to search and delete sent report notification records to allow them to be re-triggered if necessary
* Also refactored several commonly-used report tracking property names into their own constants class
  * Jeff Largent on Fri, 12 Jan 2018 15:17:36 -0500 [View Commit](../../commit/d90ef120b5aa2bf80b7bbc9671fc72371c472f04)

## coeus-1801.0020
* RESKC-2090: Don't add personnel summary totals twice
  * Jeff Largent on Wed, 10 Jan 2018 14:41:07 -0500 [View Commit](../../commit/487991668a1b10a742d4cf57386d6553af50a095)

## coeus-1801.0019
* RESKC-2717: Fix date format to show proper month (#2707)

  * Terry Durkin on Thu, 11 Jan 2018 14:07:31 -0500 [View Commit](../../commit/6ad5750b5f789e5513680128bd08d25afd63e50a)

## coeus-1801.0018
* No Changes


## coeus-1801.0017
* No Changes


## coeus-1801.0016
* RESKC-2716, RESKC-2471: show/hide t and c f coi.  Prevent STE when printing DOE fdp form.
  * Travis Schneeberger on Wed, 10 Jan 2018 16:25:57 -0500 [View Commit](../../commit/0f147b45502077287e6db12511e2ebd64cf6b98f)
* RESKC-2500: NSF CP form (#2704)

* RESKC-2500: NSF CP form
  * 
* RESKC-2500: small change
  * Gayathri Athreya on Wed, 10 Jan 2018 13:13:52 -0700 [View Commit](../../commit/a785c80489057c1c04e573ecc49b1d27246176c0)

## coeus-1801.0015
* RESKC-2624: create the correct sort order for fdp forms, cleanup unused stylesheets that have been replaced by pdf forms
  * Travis Schneeberger on Wed, 10 Jan 2018 13:56:42 -0500 [View Commit](../../commit/6d3991a63e071c3166dc27e08a5ed6fd99f43799)

## coeus-1801.0014
* RESKC-2132: Changed behavior back to only deleting pending reports when schedule changes

* Added support for manually deleting tracking entries which no longer match the schedule
* Made sure that report tracking entries are updated when report / frequency properties are changed on the associated term
  * Jeff Largent on Wed, 10 Jan 2018 11:23:56 -0500 [View Commit](../../commit/c350d1815d4447f70f1ccdd5e083187d2af20220)

## coeus-1801.0012
* RESKC-2652: increase field size in DD to match DB
  * Travis Schneeberger on Tue, 9 Jan 2018 17:42:51 -0500 [View Commit](../../commit/7da3ad3156d47db4c91b4133c20c9479cba4bfca)

## coeus-1801.0011
* RESKC-2688: Change long to varchar (#2699)

  * Gayathri Athreya on Tue, 9 Jan 2018 10:42:00 -0700 [View Commit](../../commit/ad1c4cdb8b7fd0113b8985d633eecaad593e4458)
* RESKC-2652: update fdp agreement
  * Travis Schneeberger on Tue, 9 Jan 2018 11:38:58 -0500 [View Commit](../../commit/91100a52b912aefbf332ad8f62db0ff91368d9d7)

## coeus-1801.0009
* RESKC-2642: zendesk-3192 check for null prime sponsor (#2626)

  * Noah on Mon, 8 Jan 2018 10:15:24 -0800 [View Commit](../../commit/a3b5319a8c75dc5805bdc439bb3fdc2dc107d8e5)

## coeus-1801.0008
* RESKC-869: Disabling award_id constraint until we can fix orphaned tracking records
  * Jeff Largent on Fri, 5 Jan 2018 17:34:46 -0500 [View Commit](../../commit/185b4bc6e635e62be725fc555abab4819618aa7e)

## coeus-1801.0007
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