Most Active Author

In this challenge, the REST API Contains information about
a collection of users and article they created. Given the
threshold value, the goal is to use the API to get the list
of most active authors. Specifically, the list of usernames
of the users with submission count strictly greater than the
given threshold. The list of usernames must be returned in the
order the users appear in the results.

To access the collection of users perform HTTP GET request to

http://jsonmock.hackerrank.com/api/article_users?page=<pageNumber>
where <pageNumber> is an integer denoting the page of the result
to return.

For example, GET request to:
http://jsonmock.hackerrank.com/api/article_users/search?page=2
will return the second page of the collection of users. Page are
numbered from 1, so in order to access the first page, you need to
ask for page number 1.

The response to such request is a JSON with the following 5 fields

page: The current page of the results
per_page: The maximum number of users returned per page.
total: The total number of users on all pages of the result.
total_pages: The total number of pages with result.
data: An array of objects containing users returned on the request
page.

Each user record has the following schema:

id: unique ID of the user.
username: the username of the user
about: the about information of the user.
submitted: total number of articles submitted by user.
updated_at: the date and time of the last update to this record.
submission_count: the number of submitted articles that are approved.
comment_count: the total number of comments the users made.
created_at: the date and time when the record was created.

Function description

Complete the function getUsernames in the editor below.
getUsernames has the following parameters(s):
threshold: integer denoting the threshold value for the number of
submissino count.

The function must return an array of strings denoting the usernames
of the users whose submission count is strictly greater than the threshold.
The usernames in the array must be ordered in the order they appear in the API
response.

Sample Output

epaga
panny
olalonde
wisNorCan
dmmalam
replicatorblog
vladikoff
mpweiher
coloneltcb
guelo

Explanation

The threshold value is 10 so the result must contain usernames
of users with the submission count value greater than 10. There are
10 such users and their usernames in order they first appear in the
API response are listed in Sample Output