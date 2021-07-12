// https://w.amazon.com/bin/view/CMT_Onboarding_Wiki
8738674693 - daily connect
//https://is.amazon.com/        (internal search engine)
//https://sage.amazon.com/posts/383157

// https://builderhub.corp.amazon.com/docs/bt101_online-build-service.html
https://epi-myra-jlb.corp.amazon.com/unified-promo-tool/    - upt

alok-bt101
199258474927 (aws account id)

Tool: ada
Description: Aws Developer Account
Team: Rapid Dev Cycle Team
Email: rdct-team@amazon.com

For more information about this tool, see https://w.amazon.com/bin/view/DevAccount/Docs/
To report bug/issue, see https://issues.amazon.com/issues/create?template=dc7393e0-fd39-4fda-84dc-b13dc3670301
Commands: ada

#############################################################################################

Tool: bones
Description: The BONES CLI is a walkthrough of getting started with Builder Tools and Native AWS. It will assist you in getting a brand new pipeline deploying to your
 own AWS account, either by creating a new service from scratch or by migrating an existing application.
Team: nade-team
Email: nade-team
For more information about this tool, see https://builderhub.corp.amazon.com/docs/bones-cli.html
To report bug/issue, see http://tiny.amazon.com/3dg4ktoe
Commands: bones

######################################################################

Tool: brazil-octane
Description: Octane CLI
Team: builderhub-team
Email: builderhub-team@amazon.com
For more information about this tool, see https://w.amazon.com/index.php/Octane_CLI
To report bug/issue, see https://sim.amazon.com/issues/create?assignedFolder=3e314348-d3c1-43f0-91eb-ec17de922634
Commands: brazil-octane

##################################################################
This pipeline is managed through Live Pipeline Templates. It is responsible for pushing your BT101KmarpnfLambda packages to CloudFormation.


Workspace:              kmarpnf_BT101
    Root:               /home/kmarpnf/workplace/BT101
    Version Set:        (none)
    Packages:
                        (none in packageInfo)
// https://code.amazon.com/reviews/CR-51115026       - code review
// https://code.amazon.com/reviews/CR-51115026

// https://w.amazon.com/bin/view/NinjaDevSync/            - NinjaDevSync
🍺  /usr/local/Cellar/fswatch/1.15.0: 52 files, 1.2MB
==> Installing amazon/amazon/ninja-dev-sync
🍺  /usr/local/Cellar/ninja-dev-sync/2.4.2: 3 files, 3.2MB, built in 3 seconds

/*
The Golden Rule: Only ever edit your workspace from your laptop or host machine, and never from your RHEL VM or cloud desktop. 
This includes using git, post-review, and anything else that modifies local files (excluding build). Otherwise, your changes 
will be obliterated on the next sync. You should only use your RHEL VM / cloud desktop for building and testing as necessary.

*/



1. Add dimensions for new clientIds for resolution purpose (task expansion) - 1 Day
2. FE and NA thing - marketplace there no action req
3. Resolution strategy for new clientIDs - button ( Dummy buttons without any action) - UI changes - 1 Day
4. Action on crawl replay - 3 days

1. Query and get impacted listings from Cognitum for promotion ID - 2 days
2. Perform crawl replay on impacted listings - 0 days
3. Delete entries from Rudra for given promotionID - .5 days


/*
 Myra, wibe, thanos, Lakshya garg
UPP tools - unified promotion tools
cognitum
*/
//https://access.amazon.com/aws/burner



// INtellij - The accepted certificate will be saved in truststore /Users/kmarpnf/Library/Application Support/JetBrains/IdeaIC2021.2/ssl/cacerts

#############  //https://pipelines.amazon.com/pipelines - for any epi package search

kmarpnf@147ddaa52909 EPIRebateService % cr --help
kmarpnf@147ddaa52909 EPIRebateService % git staus
kmarpnf@147ddaa52909 EPIRebateService % git diff src/com/amazon/epirebate/sop/transformer/RebateInputToErrorEntityXmer.java
kmarpnf@147ddaa52909 EPIRebateService % git add src/com/amazon/epirebate/sop/transformer/RebateInputToErrorEntityXmer.java
kmarpnf@147ddaa52909 EPIRebateService % git restore --staged EPIRebateService.iml
kmarpnf@147ddaa52909 EPIRebateService % git status
kmarpnf@147ddaa52909 EPIRebateService % git commit -m "Adding GL and Band Attributes to Error entity object"
kmarpnf@147ddaa52909 EPIRebateService % git status
kmarpnf@147ddaa52909 EPIRebateService % cr
kmarpnf@147ddaa52909 EPIRebateService % cr -r CR-CR_ID   (It will create a revision to the same CR)
git reset --soft HEAD~        =====> if you have commited and want to come back

* Would you like this to automatically note the code review url in your commits? y
* Would you like this to prompt you to relate a SIM issue if one is not specified in the description or with the --issue argument? y
* Would you like us to manage the lifecycle of SIM issues you provide or include in your description by moving them into review? n
// if foung any error on intellij
brazil-build clean
brazil ws --clean     // only this worked for me
brazil ws --sync
brazil-recursive-cmd brazil-build --allPackage   //(do this)
Go to File menu > Invalidate Caches / Restart //(do this too)
Brazil Sync from Workspace
brazil ws remove --package EPIUnifiedPromoDao



//Task1
https://code.amazon.com/reviews/CR-52031341/revisions/4#/diff
//Task2
https://code.amazon.com/reviews/CR-53068119/revisions/1#/diff
"Add Exception" User Action: If Ops wants to add an exception for a Promo to ignore a violation, then they can click on the button to add the promo to exception list
"Adding SOP Exception for Overriding(ignore SOP validation) against the PromotionId"

#### SOP Validation | Add Exception Rudra Backend Service Side Changes ####
## "Add Exception" User Action: If Ops wants to add an exception for a Promo to ignore a violation, then they can click on the button to add the promo to exception list
## The changes shall be made in EPIIREUESService package
## A new ResolveWorkActionItem needs to be created in CompSpecificResolver, to handle the new action resolution "Add Exception"
## On resolving this action item, a call should be made to UPT Library to set the override flag to true for the given promotion id.

Tasks:

1. Create a new ResolveWorkActionItem for adding SOP exception
2. Handle the resolve action, call the UPT(Unified Packing Tool) library to store the exception override against the promotion id
3. For every resolution taken, call UPT library to store the Rudra Action trace against each promotion id.
4. Before Crawl Replay, check that no crawl replay happened in the last ‘X’ minutes, by checking from the UPT library.
// google guice, Unit Testing, created various bins for dependencies injections using Mockito mock object
// did Unit testing usaing JUnit 4

/*
https://code.amazon.com/packages/EPIUnifiedPromoDao/blobs/heads/sop-sakhil-dev/--/src/com/amazon/epi/unified/promo/dao/entity/SOPExceptionOverrideInput.java
https://code.amazon.com/reviews/CR-51901804/revisions/3#/diff
https://code.amazon.com/packages/CMTCommonConstants/blobs/mainline/--/src/com/amazon/cmt/constants/Marketplace.java
*/


(my local host package)https://dev-dsk-kmarpnf-1b-b4484cea.eu-west-1.amazon.com:9443
(folder site)https://issues.amazon.com/folders/search?q=status%3A(Active)&sort=score+desc&selectedDocument=7255c656-31e7-4cdc-b309-bb301b24a05c

cd cdd2/Users/kmarpnf/workplace/epi_comSpecificWebsite/src/
ssh dev-dsk-kmarpnf-1b-b4484cea.eu-west-1.amazon.com  // - Host Name(you cansee on builderHub->cloud desk)
brazil-build server

client_loop: send disconnect: Broken pipe //- (last message and then terminal came back to local path)


######################################(SOME NEW TERMINOLOGY)##################################################################################################

(1) Asserts(assertEquals) are used to validate that properties of your system under test have been set correctly, 
whereas Verify(verify) is used to ensure that any dependencies that your system under test takes in 
have been called correctly.
(2)use @RunWith(MockitoJUnitRunner.class) or Mockito.initMocks(this) 
to initialize these mocks and inject them (JUnit 4)
(3) @Mock creates a mock. @InjectMocks creates an instance of the class and injects the mocks 
that are created with the @Mock annotations into this instance.





scp kmarpnf@dev-dsk-kmarpnf-1b-b4484cea.eu-west-1.amazon.com:/local/home/kmarpnf/cdd2/Users/kmarpnf/workplace/epi_comSpecificWebsite/build/EPICompSpecificWebsite/EPICompSpecificWebsite-1.0/AL2_x86_64/DEV.STD.PTHREAD/build/brazil-documentation/checkstyle/checkstyle_report.html /Users/kmarpnf/Desktop/task3.html
scp "source" "destination"

local/home/kmarpnf/cdd2/Users/kmarpnf/workplace/epi_comSpecificWebsite/build/EPICompSpecificWebsite/EPICompSpecificWebsite-1.0/AL2_x86_64/DEV.STD.PTHREAD/build/brazil-unit-tests/index.html





