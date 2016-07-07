VERSION 5.00
Begin VB.Form frmMain 
   BackColor       =   &H00400040&
   Caption         =   "Library Management System"
   ClientHeight    =   3195
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   4680
   BeginProperty Font 
      Name            =   "Lucida Handwriting"
      Size            =   8.25
      Charset         =   0
      Weight          =   400
      Underline       =   0   'False
      Italic          =   0   'False
      Strikethrough   =   0   'False
   EndProperty
   LinkTopic       =   "Form1"
   Picture         =   "Form1.frx":0000
   ScaleHeight     =   4.50139e5
   ScaleMode       =   0  'User
   ScaleWidth      =   4.93287e5
   StartUpPosition =   3  'Windows Default
   WindowState     =   2  'Maximized
   Begin VB.CommandButton cmdQuit 
      BackColor       =   &H00C0C0C0&
      Caption         =   "&Quit"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   8130
      Style           =   1  'Graphical
      TabIndex        =   7
      Top             =   5685
      Width           =   1485
   End
   Begin VB.CommandButton cmdReports 
      BackColor       =   &H00C0C0C0&
      Caption         =   "&Reports"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   8115
      Style           =   1  'Graphical
      TabIndex        =   6
      Top             =   4890
      Width           =   1500
   End
   Begin VB.CommandButton cmdBookreturn 
      BackColor       =   &H00C0C0C0&
      Caption         =   "Book R&eturn"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   8100
      Style           =   1  'Graphical
      TabIndex        =   5
      Top             =   4050
      Width           =   1515
   End
   Begin VB.CommandButton cmdIssuedetails 
      BackColor       =   &H00C0C0C0&
      Caption         =   "&Issue Details"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   510
      Left            =   8085
      Style           =   1  'Graphical
      TabIndex        =   4
      Top             =   3240
      Width           =   1530
   End
   Begin VB.CommandButton cmdBookrecord 
      BackColor       =   &H00C0C0C0&
      Caption         =   "B&ook Record"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   510
      Left            =   2370
      Style           =   1  'Graphical
      TabIndex        =   3
      Top             =   5625
      Width           =   1560
   End
   Begin VB.CommandButton cmdMemberinfo 
      BackColor       =   &H00C0C0C0&
      Caption         =   "&Member Info"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   2385
      Style           =   1  'Graphical
      TabIndex        =   2
      Top             =   4875
      Width           =   1530
   End
   Begin VB.CommandButton cmdFineday 
      BackColor       =   &H00C0C0C0&
      Caption         =   "&Fine / Day"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   510
      Left            =   2370
      Style           =   1  'Graphical
      TabIndex        =   1
      Top             =   4050
      Width           =   1560
   End
   Begin VB.CommandButton cmdAddstream 
      BackColor       =   &H00C0C0C0&
      Caption         =   "&Add Stream"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   12
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   525
      Left            =   2355
      Style           =   1  'Graphical
      TabIndex        =   0
      Top             =   3285
      Width           =   1605
   End
End
Attribute VB_Name = "frmMain"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False

Private Sub cmdAddStream_Click()
frmAddStream.Show
End Sub



Private Sub cmdBookRecord_Click()
frmBookRecord.Show
End Sub


Private Sub cmdBookReturn_Click()
frmBookReturn.Show
End Sub

Private Sub cmdreports_Click()
Form1.Show
End Sub

Private Sub cmdFineDay_Click()
frmFineDays.Show
End Sub

Private Sub cmdIssueDetails_Click()
frmIssueDetails.Show
End Sub

Private Sub cmdMemberInfo_Click()
frmMemberInfo.Show
End Sub

Private Sub cmdQuit_Click()
End
End Sub
