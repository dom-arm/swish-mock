# Swish mock

See the About section.

My own project I'm working on to get started with Java.

This is a Swing application and I'm using the MVC design pattern.

## Notice on my workflow

I define an issue/ticket for a feature, then create a branch from that issue.

Once the feature is complete I squash the commits, usually into a single commit that represents the change, unless multiple commits are more appropriate. Then I rebase the branch onto main.

I do this to maintain a clean linear history. When rebased and merged I delete the remote branch.

This process means my current/latest work is most often on the feature branch rather than on the main branch in the repository.

I'm considering creating a pull request whenever I create a branch from an issue so that my latest work is linked to it, making it easier for others to inspect and review my code without needing to switch to the feature branch.