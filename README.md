HHTechnical
===========

a short puzzle: Technical exercise [ Complete ] 

Assumptions: 
* The user machine will be able to execute Java.
* The program will be executed from the command line, with the user providing N as a parameter.
* The program will be shipped compiled, ie the user will not be able to see the source
 
Removed from the shipped version is debug mode, enabled by passing in a second parameter "true". The functionality enabling it has been commented out.

Choices:
* Java was selected for familiarity and also because it was the primary choice listed in the prompt
* A hashmap was used to store computed values of secret() to reduce the computational overhead of an executing isAdditive for larger N's. The performance gain can be guessed at by looking at the ratio provided in debug mode. 
* The implementation of secret() can be changed in the Secret.java class. Recompile and run Evaluate to reevaluate its additive status

Hannon Hill Writing Exercise: [ Complete ]

* Who are the three main competitors for Hannon Hill's Cascade Server? How do they differentiate themselves?
	- Sharepoint - Microsoft's collaborative document and content manager/analyzer has the capacity to produce websites as well. It is differentiated from Cascade Server by its interface and intended use - it looks like Microsoft Office and is often used to share office documents.
	- Drupal - an open-source CMS released at about the same time as Cascade Server. It's main draw is that it is free and also uses PHP, allowing published pages to interact with the server easily.
	- Wordpress - another open-source CMS. Its primary claim-to-fame is simplicity and the ease of upgrading.

* What's the difference between SharePoint and Cascade Server?
	- The main difference between SharePoint and Cascade Server should be intended application. While both can be used in similar capacities, SharePoint with its emphasis on document and content management is better suited for internal collaboration. Cascade Server on the other hand, being built to serve static websites, is well-suited to producing high traffic public-facing websites.

* What are the three most popular web development technologies?What is the relationship with those and Cascade Server?
	- The three most popular web development technologies are HTML/CSS, Javascript, and Java. As a webpage-producing CMS, Cascade Server is inextricably tied to HTML, CSS, and Javascript, the primary technologies involved in display and usage of web pages. As for Java, Cascade Server is written in Java and should handle most or all of its serverside operations.

* What are the three main industry verticals for Hannon Hill? Why are they the main ones?
	- From looking at the Customer Case Studies, the main verticals for Hannon Hill are higher education, government, and healthcare. These industries make good customers for an CMS serving static content because their websites are often used to publish high-importance reference materials. The customer support line provided by a Cascade Server subscription could be critically important to customers in these industries, moreso than say a more casual blog or journal-type website.

* What are some of the new opportunities in the CMS market?
	- Targetted marketing. Not really so important for the main customers of Cascade Server who aren't typically trying to sell things, but personalized content based on information gleaned from various user metrics.
	- Seamless upgrades. One of the issues that has plagued high-content sites (such as the types CMSs deliver) is painlessly completing a system upgrade. The typical volume of a site that needs a CMS to manage its content makes regression testing during an upgrade a serious undertaking.

