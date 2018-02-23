

## CURRENT
* RESKC-2078: update s2s, add tests
  * Travis Schneeberger on Fri, 23 Feb 2018 13:53:21 -0500 [View Commit](../../commit/3289940adca59fcf8f02f7dd278fb948335940a5)

## coeus-1802.0033
* RESKC-2491: Delete payment schedules when associated term is deleted
  * Jeff Largent on Fri, 23 Feb 2018 09:45:25 -0500 [View Commit](../../commit/4d8e83d56818b9ecc45068b00ace78a30f712645)

## coeus-1802.0032
* No Changes


## coeus-1802.0031
* RESKC-2785: Ensure internal attachment errors display when submitting to S2S
  * Jeff Largent on Thu, 22 Feb 2018 10:55:07 -0500 [View Commit](../../commit/af6af4b8f06ace3c551cff57f443169ce8e3ed74)

## coeus-1802.0030
* RESKC-2791: Update ART notifications param to send weekly
  * Jeff Largent on Wed, 21 Feb 2018 14:12:26 -0500 [View Commit](../../commit/fbd76245fe6169cd58023200bc2024bf3826e10a)

## coeus-1802.0029
* RESKC-2766: Change overdue to a dynamically calculated property
  * Jeff Largent on Tue, 20 Feb 2018 13:54:00 -0500 [View Commit](../../commit/234e82bdd018f835f228f4e777569558df9abb7d)

## coeus-1802.0028
* RESKC-2729: Fix ART ITs to abide by new constraints
  * Jeff Largent on Tue, 20 Feb 2018 12:03:04 -0500 [View Commit](../../commit/5a82545131e5b383537b12d27def294ffadd4e40)
* RESKC-2729: Clean up report tracking data that violates referential integrity

  * These scripts clean up report tracking data that was unable to to be re-mapped to the report terms associated with the latest award versions as part of commit 37e771ee9b066fc541a2bb8c39952adbf05feecd. A lot of this data was likely duplicated due to consistency issues in legacy report tracking code, such as tracking data being incorrectly copied across versions and failing to properly update report tracking properties when the associated award and award term properties were changed. Report tracking data that was unable to be adapted to the new consistency constraints will be moved to a new `award_report_tracking_backup` table. That way these entries can be examined to see if they need to be manually re-associated with award report terms or if they can be safely ignored/deleted.
  * Jeff Largent on Fri, 16 Feb 2018 16:23:35 -0500 [View Commit](../../commit/9a2c4c1cf3b6822caefb36b19f69fab068d45f09)

## coeus-1802.0027
* RESKC-2759: Added report.finalFlag as ART lookup criteria
  * Jeff Largent on Thu, 15 Feb 2018 16:52:40 -0500 [View Commit](../../commit/aeaa8106966a1d567c8e9b7b01e95b6179e40618)

## coeus-1802.0026
* No Changes


## coeus-1802.0025
* RESKC-2680: Ensure that digest parameter lists always render in lexicographical order
  * Jeff Largent on Thu, 15 Feb 2018 11:34:27 -0500 [View Commit](../../commit/5512a2653a3cb052b1c0c32c4d110fd16d606751)
* RESKC-2680: Fix typo in parameter value
  * Jeff Largent on Thu, 15 Feb 2018 10:50:17 -0500 [View Commit](../../commit/d372d9d42a9146f5fb73c806db389757a49dfe44)
* RESKC-2680: Moved trigger enabled param to spring definition
  * Jeff Largent on Thu, 15 Feb 2018 10:20:05 -0500 [View Commit](../../commit/2fde4fd08e1b7efca65a11a10893a8be9ddb0676)
* RESKC-1680: Added Oracle scripts
  * Jeff Largent on Wed, 14 Feb 2018 15:36:06 -0500 [View Commit](../../commit/411e0e93f13c8fdb3eea32ec99cb2f4437db7b58)
* RESKC-2680: Added tests and parameter for ascending unit hierarchy for unit admin digests
  * Jeff Largent on Wed, 14 Feb 2018 14:41:44 -0500 [View Commit](../../commit/4a31a3b63ec75cc55384b331f5d13e3a06b7fa5b)
* RESKC-2680: Added ART digest notification for Unit Admins

* Also added the ability for the AwardAllUnitAdministratorDerivedRoleTypeService to ascend the hierarchy if an appropriate `subunits` qualifier is provided.
  * Jeff Largent on Tue, 13 Feb 2018 13:35:42 -0500 [View Commit](../../commit/2aa6a028c3e59bb3507f82eda5c41871f623ee2b)

## coeus-1802.0024
* RESKC-2732: Adding the FF around the lock creating code as well (#2758)

  * Gayathri Athreya on Wed, 14 Feb 2018 17:21:12 -0700 [View Commit](../../commit/a0244e145d1aa1f03ee55d6a06a893f49323f6c0)

## coeus-1802.0023
* fixing Serialization issues.
  * Travis Schneeberger on Tue, 13 Feb 2018 19:20:58 -0500 [View Commit](../../commit/2d4681f5001cdfb3cb4518baf770b27ebc481af2)
* preventing NPE when missing inflation rate type during budget calculation
  * Travis Schneeberger on Tue, 13 Feb 2018 19:20:37 -0500 [View Commit](../../commit/2a5263074f8b11c2ba1acdc6dc80b9d4f7802f07)
* preventing NPE on certain KRAD lookups
  * Travis Schneeberger on Tue, 13 Feb 2018 19:19:20 -0500 [View Commit](../../commit/1ea3c078e904a8d5061afb1b81a4af7eb3c7e157)

## coeus-1802.0022
* No Changes


## coeus-1802.0021
* RESKC-2343: add test
  * Travis Schneeberger on Mon, 12 Feb 2018 11:48:21 -0500 [View Commit](../../commit/6525607110886d25574cf37ef20da491f14c1c3e)

## coeus-1802.0020
* No Changes


## coeus-1802.0019
* RESKC-2478: updating s2s  * Travis Schneeberger on Fri, 9 Feb 2018 16:04:39 -0500 [View Commit](../../commit/3c2920b9c1435f19fd465148d6a2beccaf9d9678)
* RESKC-2681: Fix Oracle script name
  * Jeff Largent on Fri, 9 Feb 2018 15:48:01 -0500 [View Commit](../../commit/f5aadf8e97f62cddca355c9dbb91c06c1ed63783)
* RESKC-2772: Make sure to update award-related properties on reports

  * This ensures that changes to the PI or Sponsor after reports are created or copied from another Award are reflected in the Report Tracking search screen.
  * Jeff Largent on Fri, 9 Feb 2018 12:04:56 -0500 [View Commit](../../commit/ffca8acef4ef808c6e825fd9caaeb20dd3862bf3)

## coeus-1802.0018
* No Changes


## coeus-1802.0017
* RESKC-2651: fdp fixes
  * Travis Schneeberger on Fri, 9 Feb 2018 12:24:47 -0500 [View Commit](../../commit/785ba1fce1c646b0ba6704978e66fab033902894)
* RESKC-2681: Fix IT
  * Jeff Largent on Fri, 9 Feb 2018 11:43:50 -0500 [View Commit](../../commit/c0b3e0511f36f715d56922fe702fc5f94c341675)
* RESKC-2681: Added Award Report Tracking digest notification for PIs (#2748)

  * This notification can be configured to send a digest email to PIs or other recipients on any Quartz-schedulable interval to inform them of any due or overdue reports associated with awards relevant to them. 
  * Jeff Largent on Fri, 9 Feb 2018 11:06:40 -0500 [View Commit](../../commit/93f296573abfde57383338de3ec9a8982b617097)

## coeus-1802.0016
* RESKC-2724: Adding generator tests
  * Travis Schneeberger on Thu, 8 Feb 2018 13:18:35 -0500 [View Commit](../../commit/43c1f68ed44287e8e2702ff47eab3173caf4f07c)

## coeus-1802.0015
* replace xalan with official xpath in the jdk
  * Travis Schneeberger on Wed, 7 Feb 2018 16:42:50 -0500 [View Commit](../../commit/d3e09c0f9d3cb3b795b263133ab4478ba1e43ade)
* RESKC-2724: support Other form 1.2
  * Travis Schneeberger on Wed, 7 Feb 2018 16:35:30 -0500 [View Commit](../../commit/778aa652272d2df403cc4883f4bbf822c3a7e8c8)

## coeus-1802.0014
* RESKC-2607:When versioning an IP from PD the Proposal Type is Changed by
  * PD.IP version should pull all data except the Proposal Type.  * vineeth on Tue, 6 Feb 2018 15:47:01 -0500 [View Commit](../../commit/1e38449d709fa2c6ea4858e298d06e0195dc77d7)

## coeus-1802.0013
* No Changes


## coeus-1802.0012
* RESKC-2732: Prevent duplicate version creation in award, subaward and IP (#2745)

* RESKC-2732: Prevent duplicate version creation in award, subaward and IP
  * 
* Refactored
  * Gayathri Athreya on Wed, 7 Feb 2018 07:45:43 -0700 [View Commit](../../commit/224fb86a5a7a485cfce25c4f4598331e5f42babe)
* RESKC-2721: code cleanup
  * Travis Schneeberger on Wed, 7 Feb 2018 09:38:44 -0500 [View Commit](../../commit/0f4c34d7c62d3067791ea06b0f4a6e21f6c93e8c)
* RESKC-2721: Fixed logic that resulted in NPE when deleting personnel
  * Tyler Wilson on Wed, 17 Jan 2018 12:09:35 -0700 [View Commit](../../commit/86e128c993cad9ab0610c7466e0bfc15e06f6126)
* RESKC-1813: Updated files per PR comments
  * Tyler Wilson on Wed, 2 Aug 2017 15:49:52 -0600 [View Commit](../../commit/9734e190cf77c5737dccb1998081e2e212e0b4e3)
* RSISSUES-332: Updated contrib with upstream/master and proposal award lookup fix
  * Tyler Wilson on Wed, 2 Aug 2017 13:06:54 -0600 [View Commit](../../commit/545ee5ee794ad0a7f432d9286d16d2b2a7ead4cd)
* RESKC-111: Changed validation to check for existence of award rather than the sponsor award id field within the award
  * aakers on Wed, 2 Aug 2017 12:52:33 -0600 [View Commit](../../commit/611dfce607c1be3fdaccc6b9ac12be3c6cbf1c7a)
* Updated CORE.md to include default values for parameters as found in kc-config-defaults.xml
  * Tyler Wilson on Fri, 2 Jun 2017 12:16:36 -0600 [View Commit](../../commit/64d5fa5a5f787c5549d056820c7b70994530936c)
* Updated CORE.md based on feedback
  * Tyler Wilson on Fri, 2 Jun 2017 09:00:48 -0600 [View Commit](../../commit/4f2ec94df40922790a6e0e12dd7b975bf76ec36b)
* Core Auth implementation in monolith
  * Tyler Wilson on Thu, 27 Apr 2017 16:30:23 -0600 [View Commit](../../commit/7ae397646e182427ce5f81160c1ef596a8e63fed)
* Core Auth implementation in monolith
  * Tyler Wilson on Thu, 27 Apr 2017 16:30:23 -0600 [View Commit](../../commit/15b165b46455effbc35ec84005748bdf960ba135)

## coeus-1802.0011
* No Changes


## coeus-1802.0010
* No Changes


## coeus-1802.0009
* RESKC-2733, RESKC-2734, RESKC-2735, RESKC-2737, RESKC-2738: fix contact mappings based on contact code
  * Travis Schneeberger on Tue, 6 Feb 2018 14:13:55 -0500 [View Commit](../../commit/8cd90b16f853f0f03f2b08b6bf54ec4b28386716)
* RESKC-1763, RESKC-2765: updating fdp forms attachment 3b and attachment 3b page2
  * Travis Schneeberger on Tue, 6 Feb 2018 11:58:01 -0500 [View Commit](../../commit/7fedb349369587ec7e5aa271d8cd738b23fcea75)
* RESKC-2729: Fix ambiguous column issue in mysql ART update script
  * Jeff Largent on Tue, 6 Feb 2018 11:41:25 -0500 [View Commit](../../commit/940512d4938a47708072dc671c7a21082a91826e)

## coeus-1802.0007
* RESKC-2678: Update award close dates on every save rather than just on the reports tab
  * Jeff Largent on Mon, 5 Feb 2018 15:38:41 -0500 [View Commit](../../commit/60f3740ddf57ca5fe6dc5d01ac4a86f64614919f)

## coeus-1802.0006
* No Changes


## coeus-1802.0005
* RESKC-2760: updating s2s.  updating other minor build dependencies
  * Travis Schneeberger on Mon, 5 Feb 2018 13:45:07 -0500 [View Commit](../../commit/d5e7277413a007a81f37b9ba84121a9044dc216a)

## coeus-1802.0004
* RESKC-2723: Move scripts to the correct folder
  * Travis Schneeberger on Mon, 5 Feb 2018 12:56:43 -0500 [View Commit](../../commit/9156abf0b0b762ccb5de5ea9efa75e7b122d24f6)
* Fix Oracle (#2736)

  * Gayathri Athreya on Mon, 5 Feb 2018 10:34:43 -0700 [View Commit](../../commit/a716aabc0e3c89c1933910045ddd70b18dc6e33b)
* Fix mysql (#2735)

  * Gayathri Athreya on Mon, 5 Feb 2018 10:04:50 -0700 [View Commit](../../commit/943f6fee4b9553358563f266a733abab0fb1944f)

## coeus-1802.0003
* RESKC-2762: NIH validation messages (#2731)

  * Gayathri Athreya on Mon, 5 Feb 2018 08:32:40 -0700 [View Commit](../../commit/4af984ce71936af919d999110cfba3ac53717c43)

## coeus-1802.0002
* RESKC-2729: Update award report tracking versioning script to disambiguate as required terms based on due date
  * Jeff Largent on Wed, 24 Jan 2018 14:34:32 -0500 [View Commit](../../commit/bfff4984eaa13b1651747cc2a4a0fe920103d427)
* RESKC-2763: Duplicate messages show up with caching enabled when using custom messages
  * Travis Schneeberger on Sat, 3 Feb 2018 08:14:57 -0500 [View Commit](../../commit/0b411c0b786db5dfd4608f10bf14d191b14d16e8)
* RESKC-2733, RESKC-2734, RESKC-2735, RESKC-2737, RESKC-2738: bug fixes, cleaning up unused elements in the fdp xml document.
  * Travis Schneeberger on Sat, 3 Feb 2018 08:13:10 -0500 [View Commit](../../commit/c5e2f9f159beb97fa028879c1ff0f3ce6ec4b6bf)
* RESKC-724: Allow updating existing report trackings even if report class...

  * ...is set to not generate reporting requirements. This way historical trackings can still be updated after that flag has been changed.
  * Jeff Largent on Fri, 26 Jan 2018 15:16:41 -0500 [View Commit](../../commit/5bbdb4768cf0f0f629fc7fd99af8c4ada38ae3a6)

## coeus-1802.0001
* RESKC-2761: Caching NIH Validation Service responses in order to avoid remote calls when S2S relevant data hasn't changed.
  * Travis Schneeberger on Wed, 31 Jan 2018 15:08:11 -0500 [View Commit](../../commit/3fe18adbf609891783c948a5d94477bc1c495c59)

## coeus-1801.0038
* RESKC-2645: Leave feedack link parameter blank to use current XML config value by default
  * Jeff Largent on Fri, 26 Jan 2018 14:52:12 -0500 [View Commit](../../commit/9a050fd82a120a2f77c6fcef1256d2fc7994f76b)

## coeus-1801.0037
* RESKC-2645: Updated PD and Budget help links to be parameter-based and point to Zendesk

* Also updated the portal "GET HELP" link to be parameterized as well
  * Jeff Largent on Thu, 25 Jan 2018 15:36:29 -0500 [View Commit](../../commit/e409b04739042d84fffd3f18c6050d5cc8f95e00)

## coeus-1801.0036
* No Changes


## coeus-1801.0035
* Reskc 2655 bilateral form (#2724)

* RESKC-2655, RESKC-2504: Subaward Modification Bilateral template.
  * 
* RESKC-2655: Remove old artifacts
  * Gayathri Athreya on Thu, 25 Jan 2018 11:34:46 -0700 [View Commit](../../commit/fd6a9ac5c275dc82e5cd298bc9ac81a084cedbef)
* RESKC-1215: MIT fix to only send ART notifications for pending trackings associated with active awards
  * Jeff Largent on Thu, 25 Jan 2018 13:17:57 -0500 [View Commit](../../commit/c1e14805356c34ddaea5f9000fb653c9187b41bc)

## coeus-1801.0033
* RESKC-2553: Apply day offsets to dates after schedule has been generated

* This allows offsets to be applied correctly to months with different numbers of days
  * Jeff Largent on Wed, 24 Jan 2018 11:33:34 -0500 [View Commit](../../commit/93dbd0b20da78f297646d338c0ebfdc932e8734d)
* RESKC-2536: create barebones DD entry for KcNotificationDocument
  * Travis Schneeberger on Wed, 24 Jan 2018 11:07:00 -0500 [View Commit](../../commit/5a7bd5c97b9ec01375da2d81b8df9db5bec8753e)
* RESKC-2270: Protect against situations where no valid entries have been set up for report class / report / frequencies
  * Jeff Largent on Fri, 12 Jan 2018 17:25:51 -0500 [View Commit](../../commit/2628363b3f3c35903b12fa80a5cde54bb5ea76d4)

## coeus-1801.0031
* No Changes


## coeus-1801.0030
* Change unitNumber to unit. (#2720)

  * Gayathri Athreya on Tue, 23 Jan 2018 10:52:53 -0700 [View Commit](../../commit/ef128a77fda252474ed3dd3bdcdfe9d7ed55ab9e)
* RESKC-2090: Don't add personnel summary totals twice
  * Jeff Largent on Tue, 23 Jan 2018 11:09:00 -0500 [View Commit](../../commit/49157a7c9a785dd51e4f7080edcc1712fd7f31fd)
* RESKC-2620:Fix tests (#2718)

  * Gayathri Athreya on Mon, 22 Jan 2018 15:36:17 -0700 [View Commit](../../commit/e8971a118900255af63fb33dfbf78f29bb574451)
* RESKC-2703: update copyright
  * Travis Schneeberger on Mon, 22 Jan 2018 11:21:12 -0500 [View Commit](../../commit/29ba91c708e60d23268d80c799a67789043188d5)
* RESKC-2719, RESKC-2651, RESKC-2654: updating fdp pdf forms
  * Travis Schneeberger on Mon, 22 Jan 2018 11:12:08 -0500 [View Commit](../../commit/d57da4803d97a950de2808893c28314a22c3b6ee)
* RESKC-2620: Add unit number to object codes table. (#2716)

* RESKC-2620: Add unit number to object codes table.
  * 
* PR review
  * Gayathri Athreya on Mon, 22 Jan 2018 14:16:34 -0700 [View Commit](../../commit/a0fb587e3958d22861295b0065de0c15173c9d7b)

## coeus-1801.0029
* No Changes


## coeus-1801.0028
* No Changes


## coeus-1801.0027
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